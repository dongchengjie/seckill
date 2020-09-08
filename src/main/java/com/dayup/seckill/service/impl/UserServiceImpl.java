package com.dayup.seckill.service.impl;

import com.dayup.seckill.entities.User;
import com.dayup.seckill.mapper.UserMapper;
import com.dayup.seckill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: 许淼
 * Date: 2020-09-07 15:07
 * Description:
 */
@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public void regist(User user) {
        userMapper.addUser(user);
    }
}
