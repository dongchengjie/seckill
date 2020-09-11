package com.dayup.seckill.service.impl;

import com.dayup.seckill.entities.CourseType;
import com.dayup.seckill.mapper.CourseTypeMapper;
import com.dayup.seckill.service.CourseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Author: 董成杰
 * Date: 2020-09-11 13:56
 * Description:课程类型服务
 */
@Service
public class CourseTypeServiceImpl implements CourseTypeService {
    @Autowired
    CourseTypeMapper courseTypeMapper;

    @Override
    @Cacheable(cacheNames = "CourseTypeServiceImpl.selectCourseType", key = "#courseType")
    public CourseType selectCourseType(int courseType) {
        return courseTypeMapper.selectCourseType(courseType);
    }
}
