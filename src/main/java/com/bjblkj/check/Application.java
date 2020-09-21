package com.bjblkj.check;

import com.bjblkj.check.config.MyProperties;
import com.bjblkj.check.utils.ApplicationContextUtil;
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
@MapperScan({"com.bjblkj.check.mapper"})
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext app = SpringApplication.run(Application.class, args);
        ApplicationContextUtil.setApplicationContext(app);
    }

}
