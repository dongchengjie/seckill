package com.dayup.seckill.service.impl;

import com.dayup.seckill.service.IPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Author: 董成杰
 * Date: 2020-09-11 21:58
 * Description:
 */
@Service
public class IPServiceImpl implements IPService {
    private static final int EXPIRE_SECONDS = 5;        //频繁操作后等待时间，单位：秒
    private static final int FREQUENT_THRESHOLD = 3;    //触发频繁操作的阈值
    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public int getFrequency(String ip) {
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        return ops.get(ip) != null ? Integer.parseInt(ops.get(ip)) : 0;
    }

    @Override
    public void setFrequency(String ip, int frequency) {
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        ops.set(ip, String.valueOf(frequency), EXPIRE_SECONDS, TimeUnit.SECONDS);
    }

    @Override
    public void frequencyIncrement(String ip) {
        int frequency = getFrequency(ip);
        setFrequency(ip, frequency + 1);
    }

    @Override
    public boolean isFrequent(String ip) {
        return getFrequency(ip) >= FREQUENT_THRESHOLD;
    }
}
