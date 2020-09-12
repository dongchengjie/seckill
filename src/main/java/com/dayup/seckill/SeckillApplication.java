package com.dayup.seckill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@MapperScan("com.dayup.seckill.mapper")//Mybatis映射文件扫描
@EnableCaching
//Redis解决分布式Session,Session生命周期30分钟
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 1800)
public class SeckillApplication {
    public static void main(String[] args) {
        SpringApplication.run(SeckillApplication.class, args);
    }
}
