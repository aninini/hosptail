package com.bjblkj.check.common.convert;

import cn.hutool.core.convert.Convert;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;

public class LocalDateConverter implements Converter<String, LocalDate> {

    @Override
    public LocalDate convert(String source) {
        LocalDate localDate=null;
        String trimTextString =source.trim();
        Integer year=null;
        Integer month=null;
        Integer day=null;
        if(trimTextString.contains("-")){
            String[] strings = trimTextString.split("-");
            if(strings.length==3){
                year= Convert.toInt(strings[0]);
                month=Convert.toInt(strings[1]);
                day=Convert.toInt(strings[2]);
            }else if(strings.length==2){
                year=Convert.toInt(strings[0]);
                month=Convert.toInt(strings[1]);
            }else if(strings.length==1){
                year=Convert.toInt(strings[0]);
            }
        }else {
            year=Convert.toInt(trimTextString);
        }
        if(year==null){
            year=0;
        }
        if(month==null){
            month=1;
        }
        if(day==null){
            day=1;
        }
        localDate=LocalDate.of(year,month,day);
        return localDate;
    }
}
