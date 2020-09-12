package com.dayup.seckill.service.impl;

import com.dayup.seckill.entities.Course;
import com.dayup.seckill.entities.Order;
import com.dayup.seckill.entities.PayStatus;
import com.dayup.seckill.mapper.OrderMapper;
import com.dayup.seckill.service.CourseService;
import com.dayup.seckill.service.OrderService;
import com.google.gson.Gson;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;

/**
 * Author: 董成杰
 * Date: 2020-09-11 9:47
 * Description:订单服务
 */
@Service
public class OrderServiceImpl implements OrderService {
    private static final String COURSE_ORDER_ROUTING_KEY = "course_order";
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    CourseService courseService;

    @Autowired
    OrderMapper orderMapper;

    /**
     * 发送订单消息
     *
     * @param username 用户名
     * @param courseNo 订购的课程号
     */
    @Override
    public void sendCourseOrderMessage(String username, int courseNo) {
        HashMap<String, String> map = new HashMap<>();
        map.put("username", username);
        map.put("courseNo", String.valueOf(courseNo));
        rabbitTemplate.convertAndSend("amq.direct", COURSE_ORDER_ROUTING_KEY, new Gson().toJson(map));
    }

    @Override
    public Integer createCourseOrder(String username, int courseNo) {
        Order order = new Order();
        Course course = courseService.getCourseByCourseNo(courseNo);
        order.setUsername(username);
        order.setCourseNo(course.getCourseNo());
        order.setCourseName(course.getCourseName());
        order.setCoursePrice(course.getCoursePrice());
        order.setPayStatus(PayStatus.UNPAID);
        order.setCreateDate(new Date(System.currentTimeMillis()));
        return orderMapper.addOrder(order);
    }
}
