package cn.tortoise.service.impl;

import cn.tortoise.constant.CommonConstant;
import cn.tortoise.dao.CourseDao;
import cn.tortoise.dao.ScheduleDao;
import cn.tortoise.dao.StudentDao;
import cn.tortoise.dao.TeacherDao;
import cn.tortoise.model.dto.CourseDetail;
import cn.tortoise.model.dto.CourseOverview;
import cn.tortoise.model.dto.ExecuteResult;
import cn.tortoise.model.dto.SelectedCourseOverview;
import cn.tortoise.model.entity.Course;
import cn.tortoise.model.entity.Schedule;
import cn.tortoise.exceptions.ExecuteException;
import cn.tortoise.exceptions.IllegalArgumentCheckedException;
import cn.tortoise.service.CourseService;
import cn.tortoise.utils.CourseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.Date;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseDao courseDao;

    @Autowired
    TeacherDao teacherDao;

    @Autowired
    ScheduleDao scheduleDao;

    @Autowired
    StudentDao studentDao;

    @Override
    @Transactional
    public ExecuteResult executeSelection(String studentId, long courseId, String md5) {

        try {
            if(!CourseUtil.md5Check(courseId, md5)){
                throw new ExecuteException("request link had been rewrote");
            }
//            Date now = new Date();
//            Schedule schedule = scheduleDao.getScheduleById(CommonConstant.SYSTEM_SCHEDULE_ID);
//            if(now.getTime() < schedule.getStartTime().getTime() || now.getTime() > schedule.getEndTime().getTime()){
//                throw new ExecuteException("system is not open");
//            }
            int insertCount = courseDao.selectCourse(studentId, courseId);
            if(insertCount <= 0){
                throw new ExecuteException("user had selected this course");
            }
            int updateCount = courseDao.increaseCourse(courseId);
            if(updateCount <= 0){
                throw new ExecuteException("The number of students is full");
            }
        } catch (ExecuteException e) {

            return new ExecuteResult(false, e.getMessage());
        }


        return new ExecuteResult(true, "");
    }

    @Override
    @Transactional
    public ExecuteResult decreaseSelectedCourse(String studentId, long courseId) {
//        Date now = new Date();
//        Schedule schedule = scheduleDao.getScheduleById(CommonConstant.SYSTEM_SCHEDULE_ID);
//        if(now.getTime() < schedule.getStartTime().getTime() || now.getTime() > schedule.getEndTime().getTime()){
//            return new ExecuteResult(false, "system is not open");
//        }
        int updateCount = courseDao.deleteSelectedCourseByStudentIdAndCourseId(studentId, courseId);
        if(updateCount <= 0){
            return new ExecuteResult(false, "you should select it first");
        }
        int decreaseCount = courseDao.decreaseCourse(courseId);
        if(decreaseCount <= 0){
            return new ExecuteResult(false, "inner error");
        }
        return new ExecuteResult(true, "");
    }


    @Override
    public ExecuteResult exportExecuteUrl(long courseId){

//        Date now = new Date();
//        Schedule schedule = scheduleDao.getScheduleById(CommonConstant.SYSTEM_SCHEDULE_ID);
//        if(now.getTime() < schedule.getStartTime().getTime() || now.getTime() > schedule.getEndTime().getTime()){
//            return new ExecuteResult(false, "");
//        }
        return new ExecuteResult(true, CourseUtil.getMd5(courseId));
    }

    @Override
    public Course getCourseById(long id) {
        return this.courseDao.getCourseById(id);
    }



    @Override
    public List<SelectedCourseOverview> getSelectedCourseByStudentId(String id, int offset, int limit) {
        if(id == null || id.length() == 0){
            throw new IllegalArgumentException("Illegal argument : " + id);
        }
        if(offset < 0 || limit - offset > CommonConstant.MAX_QUERY_NUM){
            throw new IllegalArgumentException("offset : " + offset + " limit : " + limit);
        }
        return courseDao.getSelectedCourseOverviewByStudentIdUsingOffsetAndLimit(id, offset, limit);
    }

    @Override
    public List<Course> getCourseList() {
        return courseDao.getCourseList();
    }

    @Override
    public List<Course> getCourseList(int offset, int limit) throws IllegalArgumentCheckedException {
        if(offset < 0 || limit < 0){
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
