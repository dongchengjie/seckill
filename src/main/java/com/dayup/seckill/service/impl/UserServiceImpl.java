package com.dayup.seckill.service.impl;

import com.dayup.seckill.entities.User;
import com.dayup.seckill.mapper.UserMapper;
import com.dayup.seckill.service.UserService;
import com.dayup.seckill.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Author: 许淼
 * Date: 2020-09-07 15:07
 * Description:用户服务
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public User register(String username, String password) {
        if (userMapper.selectUserByUserName(username) != null) {
            return null;
        }
        User user = new User(username, SecurityUtil.md5(password));
        return userMapper.addUser(user) > 0 ? user : null;
    }

    @Override
    public User getUserByUsername(String username) {
        return userMapper.selectUserByUserName(username);
    }

    /**
     * @param username 用户名
     * @param password 密码
     * @return 成功登录将返回用户对象，否则返回null
     */
    @Override
    public User login(String username, String password) {
        User user = getUserByUsername(username);
        if (user != null) {
            return user.getPassword().equals(SecurityUtil.md5(password)) ? user : null;
        }
        return null;
    }
}
