package com.dayup.seckill.controller;

import com.dayup.seckill.data.ErrorList;
import com.dayup.seckill.data.ResponseResult;
import com.dayup.seckill.entities.User;
import com.dayup.seckill.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Author: 董成杰
 * Date: 2020-09-13 11:38
 * Description:订单控制器
 */
@Controller
public class OrderController extends BaseController {
    @Autowired
    OrderService orderService;

    @GetMapping("/api/orderList")
    @ResponseBody
    public ResponseResult getOrderList(HttpSession session) {
        ResponseResult result = new ResponseResult();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            result.setErrorInfo(ErrorList.IDENTIFICATION_OUT_OF_DATE);//身份信息过期
            return result;
        }
        result.put("orderList", orderService.getOrderList(user.getUsername()));
        result.setErrorInfo(ErrorList.SUCCESS);
        return result;
    }
}
