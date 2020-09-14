package com.dayup.seckill.controller;

import com.dayup.seckill.data.ErrorList;
import com.dayup.seckill.data.ResponseResult;
import com.dayup.seckill.entities.User;
import com.dayup.seckill.service.OrderService;
import com.dayup.seckill.service.SeckillService;
import com.dayup.seckill.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Author: 董成杰
 * Date: 2020-09-11 8:22
 * Description:
 */
@Controller
public class SeckillController extends BaseController {
    @Autowired
    SeckillService seckillService;
    @Autowired
    OrderService orderService;

    @GetMapping("/api/getPath/{courseNo}")
    @ResponseBody
    public ResponseResult getPath(@PathVariable Integer courseNo, HttpSession session) {
        ResponseResult result = new ResponseResult();
        if (courseNo == null || !(courseNo > 0)) {
            result.setErrorInfo(ErrorList.RECEIVED_PARAM_ERROR);
            return result;
        }
        String path = UUIDUtil.uuid();
        session.setAttribute("path", path);
        result.put("path", path);
        return result;
    }

    @GetMapping("api/{p}/seckill/{courseNo}")
    @ResponseBody
    public ResponseResult getCourseDetail(@PathVariable String p, @PathVariable Integer courseNo, HttpSession session, HttpServletRequest request) {
        ResponseResult result = new ResponseResult();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            result.setErrorInfo(ErrorList.IDENTIFICATION_OUT_OF_DATE);//身份信息过期，请重新登录
            return result;
        }
        if (!(courseNo > 0)) {
            result.setErrorInfo(ErrorList.UNKOWN_COURSE);//对不起，该课程编号不存在
            return result;
        }
        String path = (String) session.getAttribute("path");
        if (!StringUtils.isEmpty(p) && !StringUtils.isEmpty(path) && path.equals(p)) {
            result = seckillService.seckill(user.getUsername(), courseNo, request);
        } else {
            result.setErrorInfo(ErrorList.SECKILL_PATH_ERROR);//您的请求地址不正确
            return result;
        }
        return result;
    }

    /**
     * 查询秒杀结果
     *
     * @param courseNo 课程号
     * @return 秒杀结果
     */
    @GetMapping("/api/seckillResult/{courseNo}")
    @ResponseBody
    public ResponseResult getSeckillResult(@PathVariable("courseNo") Integer courseNo, HttpSession session) {
        ResponseResult result = new ResponseResult();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            result.setErrorInfo(ErrorList.IDENTIFICATION_OUT_OF_DATE);//身份信息过期
            return result;
        }
        boolean bought = orderService.isBought(user.getUsername(), courseNo);
        if (bought) {
            result.setErrorInfo(ErrorList.ORDER_SUCCESS);//生成订单成功
        } else {
            result.setErrorInfo(ErrorList.SECKILL_LINE_UP);//订单生成中，请稍后
        }
        return result;
    }
}
