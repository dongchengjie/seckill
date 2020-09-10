package com.dayup.seckill.service.impl;

import com.dayup.seckill.entities.Course;
import com.dayup.seckill.entities.CourseType;
import com.dayup.seckill.mapper.CourseMapper;
import com.dayup.seckill.service.CourseService;
import com.dayup.seckill.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Author: 董成杰
 * Date: 2020-09-10 20:25
 * Description:
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseMapper courseMapper;

    @Override
    @Cacheable(cacheNames = "CourseServiceImpl.getCourseList")
    public List<Course> getCourseList() {
        List<Course> courseList = courseMapper.getCourseList();
        //课程排序
        courseList.sort((o1, o2) -> DateUtil.courseSort(o1, o2));
        return courseList;
    }

    @Override
    public Course getCourseByCourseNo(Integer courseNo) {
        return courseMapper.selectCourseByCourseNo(courseNo);
    }

    @Override
    @Cacheable(cacheNames = "CourseServiceImpl.selectCourseType", key = "#courseType")
    public CourseType selectCourseType(int courseType) {
        return courseMapper.selectCourseType(courseType);
    }

    @Override
    public List<CourseType> selectCourseTypes(List<Course> courses) {
        ArrayList<CourseType> types = new ArrayList<>();
        if (courses == null || courses.size() == 0) {
            return types;
        }
        //统计出现的所有课程类型id
        ArrayList<Integer> courseTypes = new ArrayList<>();
        for (Course course : courses) {
            int courseType = course.getCourseType();
            if (!courseTypes.contains(courseType)) {
                courseTypes.add(courseType);
            }
        }
        Collections.sort(courseTypes);
        //查出每个课程类型对应的类型名
        for (Integer courseType : courseTypes) {
            types.add(selectCourseType(courseType));
        }
        return types;
    }
}
