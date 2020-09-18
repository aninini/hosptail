package com.example.demo;

import com.example.demo.config.MyProperties;
import com.example.demo.utils.ApplicationContextUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableConfigurationProperties({MyProperties.class})
@EnableTransactionManagement
@EnableOpenApi
@MapperScan({"com.example.demo.mapper"})
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext app = SpringApplication.run(DemoApplication.class, args);
        ApplicationContextUtil.setApplicationContext(app);
    }

}
