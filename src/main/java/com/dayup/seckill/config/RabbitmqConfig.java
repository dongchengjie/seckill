package com.dayup.seckill.config;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: 董成杰
 * Date: 2020-09-11 10:06
 * Description:
 */
@Configuration
public class RabbitmqConfig {
    @Bean
    public Queue course_order() {
        return new Queue("course_order");
    }
}
