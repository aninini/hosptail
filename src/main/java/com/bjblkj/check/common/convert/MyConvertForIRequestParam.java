package com.bjblkj.check.common.convert;

import cn.hutool.core.util.StrUtil;
import com.bjblkj.check.utils.IRequestParam;
import com.bjblkj.check.utils.JacksonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import java.util.Collections;
import java.util.Set;

@Slf4j
public class MyConvertForIRequestParam implements GenericConverter{
    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        return Collections.singleton(new ConvertiblePair(String.class, IRequestParam.class));
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        if (source == null) {
            return null;
        }
        String source_str = (String) source;
        if(StrUtil.isBlank(source_str)){
            return null;
        }
        String trim_res = source_str.trim();

        String todealstring="";
        if(trim_res.startsWith("[")){
            todealstring=  trim_res.substring(1);
        }else {
            todealstring=trim_res;
        }
        if(trim_res.endsWith("]")){
            todealstring=todealstring.substring(0,todealstring.length()-1);
        }
        if(StrUtil.isBlank(todealstring)){
            return null;
        }

        if(targetType.isAssignableTo(TypeDescriptor.valueOf(IRequestParam.class))) {
            Object object= JacksonUtils.deserilizeToObject(todealstring,targetType.getObjectType());
            return object;
        }
        return null;
    }
}
