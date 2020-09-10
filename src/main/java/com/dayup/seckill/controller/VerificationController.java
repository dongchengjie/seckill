package com.dayup.seckill.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ShearCaptcha;
import com.dayup.seckill.data.ErrorList;
import com.dayup.seckill.util.VerificationUtil;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Author: 董成杰
 * Date: 2020-09-08 9:17
 * Description:图形验证码控制器
 */
@Controller
public class VerificationController {
    private static final int CODE_COUNT = 4;//验证码字符数
    private static final int THICKNESS = 4;//干扰线宽度

    /**
     * 生成图形验证码，并将验证码文字放入Session
     */
    @GetMapping("/verify")
    @ResponseBody
    public String getVerificationImage(HttpServletResponse response, HttpSession session) {
        //定义图形验证码的长、宽、验证码字符数、干扰线宽度
        ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(200, 100, CODE_COUNT, THICKNESS);
        session.setAttribute(VerificationUtil.VERIFICATION, captcha.getCode());
        try {
            //设置响应格式
            response.setContentType("image/jpeg");
            //写入到输出流
            captcha.write(response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
            return new Gson().toJson(ErrorList.VERIFICATION_FAIL);
        }
        return null;
    }
}
