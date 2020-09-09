package com.dayup.seckill.controller;

import com.dayup.seckill.entities.User;
import com.dayup.seckill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Author: 许淼
 * Date: 2020-09-07 17:28
 * Description:
 */
@Controller
public class RegistController {

    @Autowired
    private UserService userService;

    @GetMapping("/reg")
    public String regist(Model model){
        model.addAttribute("user",new User());
        return "regist";
    }

    @GetMapping("/regist")
    public User regist(User user){
        userService.regist(user);
        return user;
    }
}
