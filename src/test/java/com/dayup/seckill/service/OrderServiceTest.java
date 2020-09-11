package com.dayup.seckill.service;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.Message;
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
        String username = "tom";
        int courseNo = 2;
        orderService.sendCourseOrderMessage(username, courseNo);
    }

    @Test
    public void testCreateOrder() {
        String username = "tom";
        int courseNo = 2;
        int index = orderService.createCourseOrder(username, courseNo);
        System.out.println(index);
    }
}