package com.dayup.seckill.service;

import com.dayup.seckill.entities.Course;
import com.dayup.seckill.entities.CourseType;

import java.util.List;

/**
 * Author: 董成杰
 * Date: 2020-09-10 20:24
 * Description:课程服务
 */
public interface CourseService {
    public List<Course> getCourseList();

    public Course getCourseByCourseNo(Integer courseNo);

    public List<CourseType> selectCourseTypes(List<Course> courses);
}
