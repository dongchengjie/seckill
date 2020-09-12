package com.dayup.seckill.service.impl;

import com.dayup.seckill.data.ErrorList;
import com.dayup.seckill.data.ResponseResult;
import com.dayup.seckill.entities.Course;
import com.dayup.seckill.service.CourseService;
import com.dayup.seckill.service.IPService;
import com.dayup.seckill.service.OrderService;
import com.dayup.seckill.service.SeckillService;
import com.dayup.seckill.util.IPUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Author: 董成杰
 * Date: 2020-09-12 12:48
 * Description:秒杀服务
 */
@Service
public class SeckillServiceImpl implements SeckillService {
    @Autowired
    IPService ipService;
    @Autowired
    CourseService courseService;
    @Autowired
    OrderService orderService;

    /**
     * 秒杀课程
     *
     * @param username 用户名
     * @param courseNo 课程号
     * @param request  用户请求，用户获取用户ip地址，防止频繁操作
     */
    @Override
    public ResponseResult seckill(String username, Integer courseNo, HttpServletRequest request) {
        ResponseResult result = new ResponseResult();
        if (ipService.isFrequent(IPUtil.getIPAddress(request))) {
            result.setErrorInfo(ErrorList.FREQUENT_REQUEST);//您的请求过于频繁，请稍后再试
            return result;
        }
        if (courseService.isBought(username, courseNo)) {
            result.setErrorInfo(ErrorList.SECKILL_BOUGHT);//您已购买该课程，请去订单页面查看
            return result;
        }
        return seckill(username, courseNo);
    }

    //在缓存中操作数据，同时读操作加锁
    public synchronized ResponseResult seckill(String username, Integer courseNo) {
        ResponseResult result = new ResponseResult();
        Course course = courseService.getCourseByCourseNo(courseNo);
        int quantity = course.getStockQuantity();
        if (quantity > 0) {
            //数据库中库存和缓存中库存都减一
            courseService.modifyStockQuantity(course, quantity - 1);
            //异步生成订单
            orderService.sendCourseOrderMessage(username, courseNo);
            result.setErrorInfo(ErrorList.SECKILL_LINE_UP);//秒杀排队中
        } else {
            result.setErrorInfo(ErrorList.SECKILL_NO_QUOTE);//非常抱歉，该课程名额已满
        }
        return result;
    }

}
