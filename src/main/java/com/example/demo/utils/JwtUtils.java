package com.example.demo.utils;

import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.JWTVerifyException;
import com.auth0.jwt.internal.com.fasterxml.jackson.core.JsonParseException;
import com.auth0.jwt.internal.com.fasterxml.jackson.databind.JsonMappingException;
import com.auth0.jwt.internal.com.fasterxml.jackson.databind.ObjectMapper;
import com.example.demo.utils.AESSecretUtil;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.HashMap;
import java.util.Map;

public class JwtUtils {
	private static final String SECRET = "BJBL";

	private static final String EXP = "exp_bjbl";

	private static final String PAYLOAD = "payload";

	private static final String SECRET_BODY = "BJBLPAYLOAD";

	private static final boolean ISMAINBODY_JIAMI = false;

	/**
	 * 传入对象和过期时间
	 *
	 * @param <T>    对象的类类型
	 * @param object 任意对象
	 * @param maxAge 过期时间段 单位毫秒
	 * @return 加密后的token值
	 */
	public static <T> String sign(T object, long maxAge) {
		try {
			final JWTSigner signer = new JWTSigner(SECRET);
			final Map<String, Object> claims = new HashMap<String, Object>();
			String jsonString = "";

			if (object instanceof String) {
				jsonString = (String) object;
			} else {
				ObjectMapper mapper = new ObjectMapper();
				jsonString = mapper.writeValueAsString(object);
			}
			/**
			 * jsonString 再加密
			 */
			String jiami_res = bodyEncrypt(jsonString);
			if (ISMAINBODY_JIAMI) {
				jiami_res = bodyEncrypt(jsonString);
			} else {
				jiami_res = jsonString;
			}

			claims.put(PAYLOAD, jiami_res);
			claims.put(EXP, (System.currentTimeMillis() + maxAge) / 1000L);
			return signer.sign(claims);
		} catch (Exception e) {
			return null;
		}
	}

	// 解密，传入一个加密后的token字符串和解密后的类型
	/**
	 * 将token 解密 为原始对象
	 *
	 * @param <T>
	 * @param jwt    传入的token
	 * @param classT 解密的对象类型
	 * @return 返回解密的对象
	 */
	@SuppressWarnings("unchecked")
	public static <T> T unsign(String jwt, Class<T> classT) {
		final JWTVerifier verifier = new JWTVerifier(SECRET);
		try {
			final Map<String, Object> claims = verifier.verify(jwt);
			if (claims.containsKey(EXP) && claims.containsKey(PAYLOAD)) {
//				long exp = (Long) claims.get(EXP);
//				long currentTimeMillis = System.currentTimeMillis();
				String jiami_str = (String) claims.get(PAYLOAD);

				String json = null;
				if (ISMAINBODY_JIAMI) {
					json = bodyDecrypt(jiami_str);
				} else {
					json = jiami_str;
				}

				if (classT == String.class) {
					return (T) json;
				}
				ObjectMapper objectMapper = new ObjectMapper();
				return objectMapper.readValue(json, classT);
			}
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public <T> UnSignObject<T> unsignToUnSignObject(String jwt, Class<T> classT) throws JsonParseException, JsonMappingException, IOException, InvalidKeyException, NoSuchAlgorithmException, IllegalStateException, SignatureException, JWTVerifyException {

		final JWTVerifier verifier = new JWTVerifier(SECRET);
		UnSignObject<T> unSignObject = new UnSignObject<T>();
		final Map<String, Object> claims = verifier.verify(jwt);
		if (claims.containsKey(EXP) && claims.containsKey(PAYLOAD)) {
			String jiami_str = (String) claims.get(PAYLOAD);
			long exp = Long.valueOf(claims.get(EXP).toString());
			unSignObject.setExpireTicks(exp);
			T unsignmainobj = null;
			String json = null;
			if (ISMAINBODY_JIAMI) {
				json = bodyDecrypt(jiami_str);
			} else {
				json = jiami_str;
			}
			if (classT == String.class) {
				unsignmainobj = (T) json;
			}else{
				ObjectMapper objectMapper = new ObjectMapper();
				unsignmainobj = objectMapper.readValue(json, classT);
			}
			unSignObject.setUnsignObject(unsignmainobj);
		}
		return unSignObject;
	}

	public static String bodyEncrypt(String data) {
		String jiami_res = "";
		jiami_res = AESSecretUtil.encryptToStr(data, SECRET_BODY);
		return jiami_res;
	}

	public static String bodyDecrypt(String data) {
		String huanyuan_res = "";
		huanyuan_res = AESSecretUtil.decryptToStr(data, SECRET_BODY);
		return huanyuan_res;

	}

	public class UnSignObject<S> {

		/**
		 * 过期时间戳 单位:秒
		 */
		private Long expireTicks;

		private S unsignObject;

		public Long getExpireTicks() {
			return expireTicks;
		}

		public void setExpireTicks(Long expireTicks) {
			this.expireTicks = expireTicks;
		}

		public S getUnsignObject() {
			return unsignObject;
		}

		public void setUnsignObject(S unsignObject) {
			this.unsignObject = unsignObject;
		}
	}
}