package cn.tortoise.service;

import cn.tortoise.dto.CourseDetail;
import cn.tortoise.dto.CourseOverview;
import cn.tortoise.dto.ExecuteResult;
import cn.tortoise.dto.SelectedCourseOverview;
import cn.tortoise.entity.Course;
import cn.tortoise.entity.SelectedCourse;
import cn.tortoise.exceptions.ExecuteException;
import cn.tortoise.exceptions.IllegalArgumentCheckedException;

import java.util.List;
import java.util.concurrent.Executors;

public interface CourseService {

    ExecuteResult executeSelection(String studentId, long courseId, String md5) throws ExecuteException;

    public ExecuteResult exportExecuteUrl(long courseId);

    Course getCourseById(long id);

    List<SelectedCourseOverview> getSelectedCourseByStudentId(String id) throws IllegalArgumentCheckedException;

    List<SelectedCourseOverview> getSelectedCourseByStudentId(String id, int offset, int limit) throws IllegalArgumentCheckedException;

    List<Course> getCourseList() throws IllegalArgumentCheckedException;

    List<Course> getCourseList(int offset, int limit) throws IllegalArgumentCheckedException;

    CourseOverview transformToCourseOverview(Course original);

    CourseDetail transformToCourseDetail(Course original);

    List<CourseOverview> transformToCourseOverview(List<Course> original);

    List<CourseDetail> transformToCourseDetail(List<Course> original);

    void fillOtherProperties(Course course, CourseDetail courseDetail);

    void fillOtherProperties(Course course, CourseOverview courseOverview);
}
