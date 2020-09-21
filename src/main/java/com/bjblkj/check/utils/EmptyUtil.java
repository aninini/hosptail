package com.bjblkj.check.utils;

import com.bjblkj.check.common.dto.output.Ret;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class EmptyUtil {

    public static void update(Boolean b, String fullMsg) {
        if (!b) { throw new RuntimeException(fullMsg); }
    }


    //判断output参数
    public static <T> Ret result(T obj, String okMsg, String fullMsg) {
        if (obj == null) {
            return Ret.err(fullMsg);
        } else {
            return Ret.ok(okMsg, obj);
        }
    }


    //判断input参数
    public static <T> void isEmpty(T obj, String msg) {

        if (obj == null) {
            throw new RuntimeException(msg);
        }
        if (obj instanceof List) {
            if (((List) obj).isEmpty()) {
                throw new RuntimeException(msg);
            }
        }
        if (obj instanceof String) {
            if (StringUtils.isBlank((String) obj)) {
                throw new RuntimeException(msg);
            }
        }
        if (obj == null) {
            throw new RuntimeException(msg);
        }
    }

}
