package com.dayup.seckill.controller;

import com.dayup.seckill.data.ErrorList;
import com.dayup.seckill.data.ResponseResult;
import com.dayup.seckill.entities.User;
import com.dayup.seckill.service.UserService;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Author: 董成杰
 * Date: 2020-09-10 10:32
 * Description:用户控制器
 */
@Controller
public class UserController extends BaseController{
    @Autowired
    UserService userService;

    /**
     * 用户注册
     *
     * @param username 注册用户名
     * @param password 注册密码
     * @return 注册结果
     */
    @PostMapping("/api/register")
    @ResponseBody
    public ResponseResult register(String username, String password) {
        User user = userService.register(username, password);
        ResponseResult result = new ResponseResult();
        if (user == null) {
            result.setErrorInfo(ErrorList.EXISTED_USERNAME);
            return result;
        }
        result.put("user", user);
        return result;
    }

    @PostMapping("/api/login")
    @ResponseBody
    public ResponseResult login(String username, String password, HttpSession session) {
        ResponseResult result = new ResponseResult();
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            result.setErrorInfo(ErrorList.FAIL);
            return result;
        }
        User user = userService.login(username, password);
        if (user == null) {
            result.setErrorInfo(ErrorList.USER_LOGIN_FAIL);
            return result;
        }
        //登录用户放入Session
        session.setAttribute("user", user);
        result.setErrorInfo(ErrorList.SUCCESS);
        return result;
    }
}
