package cn.tortoise.service.impl;

import cn.tortoise.dao.CourseDao;
import cn.tortoise.dao.TeacherDao;
import cn.tortoise.dto.CourseDetail;
import cn.tortoise.dto.CourseOverview;
import cn.tortoise.dto.SelectedCourseOverview;
import cn.tortoise.entity.Course;
import cn.tortoise.exceptions.IllegalArgumentCheckedException;
import cn.tortoise.service.CourseService;
import cn.tortoise.utils.CourseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseDao courseDao;

    @Autowired
    TeacherDao teacherDao;

    @Override
    public List<SelectedCourseOverview> getSelectedCourseByStudentId(String id) throws IllegalArgumentCheckedException {
        if(id == null || id.length() == 0){
            throw new IllegalArgumentCheckedException("Illegal argument : " + id);
        }
        return courseDao.getSelectedCourseOverviewById(id);
    }

    @Override
    public List<SelectedCourseOverview> getSelectedCourseByStudentId(String id, int offset, int limit) throws IllegalArgumentCheckedException {
        if(id == null || id.length() == 0){
            throw new IllegalArgumentCheckedException("Illegal argument : " + id);
        }
        return courseDao.getSelectedCourseOverviewByIdUsingOffsetAndLimit(id, offset, limit);
    }

    @Override
    public List<Course> getCourseList() throws IllegalArgumentCheckedException {
        return courseDao.getCourseList();
    }

    @Override
    public List<Course> getCourseList(int offset, int limit) throws IllegalArgumentCheckedException {
        if(offset < 0 || limit < offset){
            throw new IllegalArgumentCheckedException();
        }
        return courseDao.getCourseListUsingOffsetAndLimit(offset, limit);
    }

    @Override
    public CourseOverview transformToCourseOverview(Course original) {
        CourseOverview co = new CourseOverview(original.getId(), original.getName(),
                original.getCreditPoint(), original.getCreditHours(), original.getMaxNumber(),
                original.getCurrentNumber(), original.getStartTime(), original.getEndTime());

        fillOtherProperties(original, co);
        return co;
    }

    @Override
    public CourseDetail transformToCourseDetail(Course original) {
        CourseDetail cd = new CourseDetail(original.getId(), original.getName(),
                original.getCreditPoint(), original.getCreditHours(), original.getMaxNumber(),
                original.getCurrentNumber(), original.getStartTime(), original.getEndTime(), original.getDetail());
        fillOtherProperties(original, cd);
        return cd;
    }

    @Override
    public List<CourseOverview> transformToCourseOverview(List<Course> original) {
        List<CourseOverview> list = new LinkedList<>();
        for(Course course : original){
            list.add(transformToCourseOverview(course));
        }
        return list;
    }

    @Override
    public List<CourseDetail> transformToCourseDetail(List<Course> original) {
        List<CourseDetail> list = new LinkedList<>();
        for(Course course : original){
            list.add(transformToCourseDetail(course));
        }
        return list;
    }

    @Override
    public void fillOtherProperties(Course course, CourseDetail courseDetail) {
        courseDetail.setTransformedProperties(
                teacherDao.getNameById(course.getTeacherId()),
                CourseUtil.decodeDays(course.getDays()),
                CourseUtil.decodeWeeks(course.getWeeks()),
                CourseUtil.decodeClassTime(course.getClassTime()),
                CourseUtil.decodeAllowGrade(course.getAllowGrade()));
    }

    @Override
    public void fillOtherProperties(Course course, CourseOverview courseOverview) {
        courseOverview.setTransformedProperties(
                teacherDao.getNameById(course.getTeacherId()),
                CourseUtil.decodeDays(course.getDays()),
                CourseUtil.decodeWeeks(course.getWeeks()),
                CourseUtil.decodeClassTime(course.getClassTime()),
                CourseUtil.decodeAllowGrade(course.getAllowGrade()));
    }
}
