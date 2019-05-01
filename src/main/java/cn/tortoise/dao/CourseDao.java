package cn.tortoise.dao;

import cn.tortoise.dto.SelectedCourseOverview;
import cn.tortoise.entity.Course;
import cn.tortoise.entity.SelectedCourse;
import org.apache.ibatis.annotations.Param;

import java.util.List;



public interface CourseDao {
    //
    int addNewCourse(Course course);

    // delete course by id
    int deleteCourseById(long id);

    // get course by id
    Course getCourseById(long id);

    List<Course> getCourseList();

    // get course list using limit and offset
    List<Course> getCourseListUsingOffsetAndLimit(@Param("offset")int offset, @Param("limit")int limit);

    // get course num
    int getCourseNum();

    //
    List<SelectedCourseOverview> getSelectedCourseOverviewById(@Param("id")String id);

    //
    List<SelectedCourseOverview> getSelectedCourseOverviewByIdUsingOffsetAndLimit(@Param("id")String id, @Param("offset")int offset, @Param("limit")int limit);

    int decreaseCourse(long courseId);
}
