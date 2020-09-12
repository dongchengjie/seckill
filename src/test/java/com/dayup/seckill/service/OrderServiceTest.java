package com.dayup.seckill.service;

import com.dayup.seckill.entities.Course;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

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

    @Test
    public void date() {
        List<String> sl = new ArrayList<>();
        List<String> el = new ArrayList<>();
        for (int i = 0; i < 27; i++) {
            long now = System.currentTimeMillis();
            long day = 24 * 3600 * 1000;
            long start;
            if (Math.random() > 0.2) {
                start = (long) (now + Math.random() * day * 5);
            } else {
                start = (long) (now + Math.random() * day * 5);
            }
            long last = (long) (Math.random() * day * 30);
            long end = start + last;
            Date s = new Date(start);
            s.setSeconds(0);
            Date e = new Date(end);
            e.setSeconds(0);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String s1 = format.format(s);
            String s2 = format.format(e);
            sl.add("'" + s1 + "'");
            el.add("'" + s2 + "'");
        }
        for (String s : sl) {
            System.out.println(s);
        }
        System.out.println("-------------------------------");
        for (String s : el) {
            System.out.println(s);
        }
    }
}