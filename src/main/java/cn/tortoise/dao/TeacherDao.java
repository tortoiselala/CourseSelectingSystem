package cn.tortoise.dao;

import cn.tortoise.entity.Course;
import cn.tortoise.entity.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface TeacherDao {
    // password
    String getPasswordById(String id);

    // name
    String getNameById(String id);

    // get
    Teacher getTeacherById(String id);

    // update login date
    int updateLoginDateById(@Param("id")String id, @Param("date")Date date);

    // get course by id
    List<Course> getAllCourseById(String teacherId);
}
