package com.bjblkj.check.common.convert;

import cn.hutool.core.util.StrUtil;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimeConverter implements Converter<String, LocalDateTime> {
    @Override
    public LocalDateTime convert(String source) {
        LocalDateTime localDateTime = null;
        String trimTextString = source.trim();

        if (StrUtil.isNotBlank(trimTextString)) {
            String[] strings =null;
            if(trimTextString.contains(" ")){
                strings= trimTextString.split(" ");
            }else if(trimTextString.contains("T")){
                strings= trimTextString.split("T");
            }else {
                strings=new String[]{trimTextString};
            }

            if (StrUtil.isNotBlank(strings[0])) {
                LocalDate localDate = new LocalDateConverter().convert(strings[0]);
                LocalTime localTime = null;
                if (strings.length == 2) {
                    if (StrUtil.isNotBlank(strings[1])) {
                        localTime = new LocalTimeConverter().convert(strings[1]);
                    }
                }else {
                    localTime=LocalTime.of(0,0,0,0);
                }
                localDateTime = localDate.atTime(localTime);
            } else {
                localDateTime = null;
            }
        } else {
            localDateTime = null;
        }
        return localDateTime;
    }
}
