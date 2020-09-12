package com.dayup.seckill.entities;

import lombok.Data;

import java.io.Serializable;

/**
 * Author: 董成杰
 * Date: 2020-09-10 22:41
 * Description:课程类型
 */
@Data
public class CourseType implements Serializable {
    private int courseType;     //课程类型id
    private String typeName;    //类型名
}
