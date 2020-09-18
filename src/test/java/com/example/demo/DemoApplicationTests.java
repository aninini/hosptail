package com.example.demo;

import com.example.demo.entities.UserCase;
import com.example.demo.utils.EmptyUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        UserCase userCase = new UserCase();
//        ArrayList<String> list = new ArrayList<>();
        Long a = null;
        EmptyUtil.isEmpty(a,"邮件不能为空");
        System.out.println("ok");
    }

}
