package com.dayup.seckill.service;

import com.dayup.seckill.entities.User;

/**
 * Author: 许淼
 * Date: 2020-09-07 15:07
 * Description:
 */
public interface UserService {
    User register(String username,String password);

    User getUserByUsername(String username);

    User login(String username,String password);
}
