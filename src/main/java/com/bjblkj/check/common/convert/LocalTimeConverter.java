package com.bjblkj.check.common.convert;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalTime;

public class LocalTimeConverter implements Converter<String, LocalTime> {


    @Override
    public LocalTime convert(String source) {
        LocalTime localTime = null;
        String trimstring = source.trim();
        Integer hour = null;
        Integer minutes = null;
        Integer seconds = null;
        if (StrUtil.isNotBlank(trimstring)) {
            String[] strings = trimstring.split(":");
            if (strings.length == 3) {
                hour = Convert.toInt(strings[0]);
                minutes = Convert.toInt(strings[1]);
                seconds = Convert.toInt(strings[2]);
            } else if (strings.length == 2) {
                hour = Convert.toInt(strings[0]);
                minutes = Convert.toInt(strings[1]);
            }else if(strings.length == 1){
                hour = Convert.toInt(strings[0]);
            } else {
                localTime = LocalTime.of(0, 0, 0, 0);
                return localTime;
            }
        }
        if (hour == null) {
            hour = 0;
        }
        if (minutes == null) {
            minutes = 0;
        }
        if (seconds == null) {
            seconds = 0;
        }
        localTime = LocalTime.of(hour, minutes, seconds,0);
        return localTime;
    }
}
