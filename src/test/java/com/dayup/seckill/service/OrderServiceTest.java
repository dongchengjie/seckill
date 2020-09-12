package com.dayup.seckill.service;

import com.dayup.seckill.entities.Course;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class OrderServiceTest {
    @Autowired
    OrderService orderService;
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    RedisTemplate<String, Object> redisTemplate;
    @Autowired
    IPService ipService;

    @Autowired
    CourseService courseService;

    @Test
    public void testSendCourseOrderMessage() {
        orderService.sendCourseOrderMessage("jack", 2);
        orderService.sendCourseOrderMessage("jack", 2);
        orderService.sendCourseOrderMessage("jack", 3);
    }

    @Test
    public void testCreateOrder() {
        String username = "tom";
        int courseNo = 2;
        int index = orderService.createCourseOrder(username, courseNo);
        System.out.println(index);
    }

    @Test
    public void testIP() {
        Course course = courseService.getCourseByCourseNo(1);
        System.out.println(course);
        Course course1 = courseService.modifyStockQuantity(course, course.getStockQuantity() + 1);
        System.out.println(course1);

    }
}