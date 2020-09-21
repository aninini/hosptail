package com.bjblkj.check.common.convert;


import com.bjblkj.check.utils.ISearchParam;
import com.bjblkj.check.utils.JacksonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import java.util.Collections;
import java.util.Set;

@Slf4j
public class MyConvertForISearchParam implements GenericConverter {
    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        return Collections.singleton(new ConvertiblePair(String.class, ISearchParam.class));
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        if (source == null) {
            return null;
        }
        String string = (String) source;
        if(targetType.isAssignableTo(TypeDescriptor.valueOf(ISearchParam.class))) {
            Object object= JacksonUtils.deserilizeToObject(string,targetType.getObjectType());;
            return object;
        }
        return null;
    }
}
