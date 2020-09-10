package com.dayup.seckill.service;

import com.dayup.seckill.entities.User;
import com.dayup.seckill.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 测试用户服务
 */
@SpringBootTest
class UserServiceTest {
    @Autowired
    UserMapper mapper;
    @Autowired
    UserService service;
    @Test
    void register() {
        User user = service.register("1r23", "123456");
        System.out.println(user);
    }

    @Test
    void getUserByUsername() {
    }
}