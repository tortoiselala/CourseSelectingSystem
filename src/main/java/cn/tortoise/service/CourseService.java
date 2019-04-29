package cn.tortoise.service;

import cn.tortoise.dto.CourseDetail;
import cn.tortoise.dto.CourseOverview;
import cn.tortoise.dto.SelectedCourseOverview;
import cn.tortoise.entity.Course;
import cn.tortoise.entity.SelectedCourse;

import java.util.List;

public interface CourseService {

    List<SelectedCourseOverview> getSelectedCourseById(String id);

    List<SelectedCourseOverview> getSelectedCourseById(String id, int offset, int limit);

    List<Course> getCourse();

    List<Course> getCourse(int offset, int limit);

    CourseOverview transformToCourseOverview(Course original);

    CourseDetail transformToCourseDetail(Course original);

    List<CourseOverview> transformToCourseOverview(List<Course> original);

    List<CourseDetail> transformToCourseDetail(List<Course> original);

    void fillOtherProperties(Course course, CourseDetail courseDetail);

    void fillOtherProperties(Course course, CourseOverview courseOverview);
}
