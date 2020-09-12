package com.dayup.seckill.mapper;

import com.dayup.seckill.entities.CourseType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * Author: 董成杰
 * Date: 2020-09-11 13:59
 * Description:
 */
@Mapper
@Component
public interface CourseTypeMapper {
    @Select("select * from course_type where course_type=#{courseType}")
    CourseType selectCourseType(int courseType);
}
