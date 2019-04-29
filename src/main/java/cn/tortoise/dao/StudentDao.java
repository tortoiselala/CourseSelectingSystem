package cn.tortoise.dao;
import cn.tortoise.entity.SelectedCourse;
import cn.tortoise.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface StudentDao {
    // get password
    String getPasswordById(String id);
    // update login date
    int updateLoginDateById(@Param("id")String id, @Param("date") Date date);
    // get student
    Student getStudentById(String id);
    // select course
    int selectCourse(@Param("studentId")String studentId, @Param("courseId")long courseId);
    // get all selected course
    List<SelectedCourse> getAllSelectedCourseById(String id);
}
