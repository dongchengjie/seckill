package com.dayup.seckill.controller;

import cn.hutool.core.lang.UUID;
import com.dayup.seckill.data.ErrorList;
import com.dayup.seckill.data.ResponseResult;
import com.dayup.seckill.entities.Course;
import com.dayup.seckill.util.UUIDUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Author: 董成杰
 * Date: 2020-09-11 8:22
 * Description:
 */
@Controller
public class SeckillController extends BaseController {
    @GetMapping("/api/getPath/{courseNo}")
    @ResponseBody
    public ResponseResult getPath(@PathVariable Integer courseNo, HttpSession session) {
        ResponseResult result = new ResponseResult();
        if (courseNo == null || !(courseNo > 0)) {
            result.setErrorInfo(ErrorList.RECEIVED_PARAM_ERROR);
            return result;
        }
        String path = UUIDUtil.uuid();
        session.setAttribute("path", path);
        result.put("path", path);
        return result;
    }
}
