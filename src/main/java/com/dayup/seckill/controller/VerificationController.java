package com.dayup.seckill.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.server.HttpServerRequest;
import cn.hutool.http.server.HttpServerResponse;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Author: 董成杰
 * Date: 2020-09-08 9:17
 * Description:图形验证码控制器
 */
@Controller
public class VerificationController {
    /**
     * 生成图形验证码，并将验证码文字放入Session
     */
    @GetMapping("/verify")
    @ResponseBody
    public String getVerificationImage(HttpServletResponse response, HttpSession session) {
        LineCaptcha captcha = CaptchaUtil.createLineCaptcha(200, 100);
        session.setAttribute("verify", captcha.getCode());
        //设置响应格式
        response.setContentType("image/jpeg");
        try {
            captcha.write(response.getOutputStream());
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "re";
    }
}
