package com.dayup.seckill;

import com.dayup.seckill.entities.User;
import com.dayup.seckill.service.UserService;
import com.dayup.seckill.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SeckillApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private User user;

    @Test
    void contextLoads() {
        user.setUsername("xm");
        user.setPassword("xm");
        System.out.println(user);
        userService.regist(user);
    }

}
