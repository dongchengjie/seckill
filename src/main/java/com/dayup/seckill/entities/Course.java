package com.dayup.seckill.entities;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Author: 董成杰
 * Date: 2020-09-10 20:13
 * Description:
 */
@Component
@Data
public class Course implements Serializable {
    private int courseNo;               //课程号
    private int courseType;             //课程分类
    private String courseName;          //课程名称
    private String teacherName;         //讲师名字
    private String courseDescription;    //课程描述
    private Date startTime;             //选课开始时间
    private Date endTime;               //选课结束时间
    private BigDecimal coursePrice;     //课程价格
    private int stockQuantity;          //库存
    private String coursePic;           //课程图片url
}
