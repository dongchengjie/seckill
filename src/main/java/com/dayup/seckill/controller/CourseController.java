package com.dayup.seckill.controller;

import com.dayup.seckill.data.ResponseResult;
import com.dayup.seckill.entities.Course;
import com.dayup.seckill.entities.CourseType;
import com.dayup.seckill.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Author: 董成杰
 * Date: 2020-09-10 20:08
 * Description:
 */
@Controller
public class CourseController extends BaseController {
    @Autowired
    CourseService courseService;

    @GetMapping("/api/courseList")
    @ResponseBody
    public ResponseResult getCourseList() {
        ResponseResult result = new ResponseResult();
        List<Course> courses = courseService.getCourseList();
        //同时查询出课程涉及的类型信息，供前台展示种类tab
        List<CourseType> courseTypes = courseService.selectCourseTypes(courses);
        result.put("courseList", courses);
        result.put("courseTypes", courseTypes);
        result.setMessage("获取课程列表成功");
        return result;
    }

    @GetMapping("/api/courseDetail/{courseNo}")
    @ResponseBody
    public ResponseResult getCourseDetail(@PathVariable Integer courseNo) {
        ResponseResult result = new ResponseResult();
        if (courseNo == null || !(courseNo > 0)) {
            return result;
        }
        Course course = courseService.getCourseByCourseNo(courseNo);
        result.put("course", course);
        return result;
    }
}
