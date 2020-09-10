package com.dayup.seckill.mapper;

import com.dayup.seckill.entities.Course;
import com.dayup.seckill.entities.CourseType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Author: 董成杰
 * Date: 2020-09-10 20:27
 * Description:
 */
@Mapper
@Component
public interface CourseMapper {
    @Select("select * from course")
    public List<Course> getCourseList();

    @Select("select * from course where course_no = #{courseNo}")
    public Course selectCourseByCourseNo(@Param("courseNo") Integer courseNo);

    @Select("select * from course_type where course_type=#{courseType}")
    CourseType selectCourseType(int courseType);
}
