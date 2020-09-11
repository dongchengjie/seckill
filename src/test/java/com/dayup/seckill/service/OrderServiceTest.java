package com.dayup.seckill.service;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderServiceTest {
    @Autowired
    OrderService orderService;
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void testSendCourseOrderMessage() {
        orderService.sendCourseOrderMessage("jack",2);
        orderService.sendCourseOrderMessage("jack",2);
        orderService.sendCourseOrderMessage("jack",3);
    }

    @Test
    public void testCreateOrder() {
        String username = "tom";
        int courseNo = 2;
        int index = orderService.createCourseOrder(username, courseNo);
        System.out.println(index);
    }
}