package com.dayup.seckill.controller;

import com.dayup.seckill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Author: 许淼
 * Date: 2020-09-07 15:08
 * Description:
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

}
