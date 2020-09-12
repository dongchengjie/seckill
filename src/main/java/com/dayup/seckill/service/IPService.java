package com.dayup.seckill.service;

/**
 * Author: 董成杰
 * Date: 2020-09-11 21:56
 * Description:IP服务
 */
public interface IPService {
    public int getFrequency(String ip);

    public void setFrequency(String ip,int frequency);

    public void frequencyIncrement(String ip);

    public boolean isFrequent(String ip);
}
