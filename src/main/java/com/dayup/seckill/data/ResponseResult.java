package com.dayup.seckill.data;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: 董成杰
 * Date: 2020-09-10 15:28
 * Description:
 */
public class ResponseResult extends IResult {
    public Map<String, Object> data = new HashMap<>();

    public void put(String key, Object object) {
        data.put(key, object);
    }

    public Object get(String key) {
        return data.get(key);
    }
}
