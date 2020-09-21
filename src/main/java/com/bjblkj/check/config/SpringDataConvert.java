package com.bjblkj.check.config;

import com.bjblkj.check.common.convert.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Configuration
public class SpringDataConvert {

    @Resource
    private RequestMappingHandlerAdapter requestMappingHandlerAdapter;

    @PostConstruct
    public void addConversionConfig() {
        ConfigurableWebBindingInitializer initializer = (ConfigurableWebBindingInitializer) requestMappingHandlerAdapter.getWebBindingInitializer();
        if (initializer.getConversionService() != null) {
            GenericConversionService genericConversionService = (GenericConversionService)initializer.getConversionService();
            genericConversionService.addConverter(new MyConvertForIRequestParam());
            genericConversionService.addConverter(new MyConvertForISearchParam());

            FormattingConversionService formattingConversionService = (FormattingConversionService) initializer.getConversionService();
            formattingConversionService.addConverter(new LocalTimeConverter());
            formattingConversionService.addConverter(new LocalDateConverter());
            formattingConversionService.addConverter(new LocalDateTimeConverter());
        }
    }

}
