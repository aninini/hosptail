package com.bjblkj.check;

import com.bjblkj.check.entities.UserCase;
import com.bjblkj.check.utils.EmptyUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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
