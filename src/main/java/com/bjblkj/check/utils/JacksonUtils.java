package com.bjblkj.check.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class JacksonUtils {

    public static String objectToJsonString(Object object){
        String res="";
        ObjectMapper mapper = new ObjectMapper();
        try {
            res= mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error("对象转json字符串发生异常",e);
        }
        return res;
    }

    public static <T> T deserilizeToObject(String jsonstr,Class<T> tClass){
        T object=null;
        ObjectMapper mapper = new ObjectMapper();
        //忽略在json字符串中存在，在java类中不存在字段，防止错误
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        //解决localdatetime反序列化的问题
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.registerModule(new JavaTimeModule());
        try {
            object= mapper.readValue(jsonstr,tClass);
        } catch (IOException e) {
            log.error(String.format("转换异常,目标类型:%s",tClass.getName()));
            log.error(e.getMessage(),e);
        }
        return object;
    }

    public static JsonNode jsonStrToJsonNode(String text){
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = null;
        try {
            jsonNode = mapper.readTree(text);
        } catch (JsonProcessingException e) {
            log.error("json字符串转JsonNode发生异常");
            log.error(e.getMessage(),e);
        }
        return jsonNode;
    }
}
