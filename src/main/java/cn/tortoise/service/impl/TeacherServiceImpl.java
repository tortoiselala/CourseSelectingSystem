package cn.tortoise.service.impl;

import cn.tortoise.constant.CommonConstant;
import cn.tortoise.dao.CourseDao;
import cn.tortoise.dao.TeacherDao;
import cn.tortoise.model.dto.StudentScoreOverview;
import cn.tortoise.model.dto.TeacherCourseOverview;
import cn.tortoise.model.entity.Course;
import cn.tortoise.model.entity.SelectedCourse;
import cn.tortoise.model.entity.StudentScore;
import cn.tortoise.model.entity.User;
import cn.tortoise.service.TeacherService;
import cn.tortoise.utils.CourseUtil;
import cn.tortoise.utils.PasswordHandler;
import cn.tortoise.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherDao teacherDao;

    @Autowired
    CourseDao courseDao;

    @Override
    public boolean authCheck(User user) {
        UserUtil.userParmCheck(user);
        return teacherDao.getPasswordById(user.getUsername()).equals(PasswordHandler.encryption(user.getPassword()));
    }

    @Override
    public List<TeacherCourseOverview> getPublishedCourseListById(String id, int offset, int limit){
        if(offset < 0 || limit - offset > CommonConstant.MAX_QUERY_NUM){
            throw new IllegalArgumentException("offset : " + offset + " limit : " + limit);
        }
        return courseDao.getPublishedCourseListByTeacherIdUsingOffsetAndLimit(id, offset, limit);
    }

    @Override
    public boolean deleteCourseByCourseId(String teacherId, long courseId){
        if(courseDao.deleteCourseById(teacherId, courseId) <= 0){
            return false;
        }
        return true;
    }

    @Override
    public List<StudentScoreOverview> getStudentOverviewByCourseId(String teacherId, long courseId) {
       List<StudentScore> list = courseDao.getStudentListWhoChosenTargetCourse(courseId);
       if(list == null){
           list = new LinkedList<>();
       }
       return overviewTransfer(list);
    }

    @Override
    public boolean updateScore(String studentId, String teacherId, long courseId, int score) {
        // 成绩范围校验
        if(!CourseUtil.scoreCheck(score)){
            throw new IllegalArgumentException("score : " + score);
        }

        // 教师权限校验：规定教师只能更改自己发布的课程的成绩
        Course course = courseDao.getCourseById(courseId);
        if(!course.getTeacherId().equals(teacherId)){
            throw new IllegalStateException("permission denied");
        }

        // 学生信息校验：校验选课表中是否有该学生
        SelectedCourse sc = courseDao.getSelectedCourse(studentId, courseId);
        if(sc == null){
            throw new IllegalStateException("didn't find items");
        }

        int result = courseDao.updateScoreByStudentIdAndCourseId(studentId, courseId, score);
        if(result <= 0){
            return false;
        }
        return true;
    }

    @Override
    public int getPublishedCourseCount(String teacherId) {
        return courseDao.getPublishedCourseCountById(teacherId);
    }

    @Override
    public TeacherCourseOverview getPublishedCourseByCourseIdAndTeacherId(long courseId, String teacherId) {
        return courseDao.getPublishedCourseByCourseIdAndTeacherId(courseId, teacherId);
    }

    @Override
    public int addNewCourse(Course course) {
        return courseDao.addNewCourse(course);
    }

    /**
     * 包含学生基本信息与成绩的视图转换
     * @param ss 原始数据
     * @return 转换后的数据
     */
    private StudentScoreOverview overviewTransfer(StudentScore ss){
        StudentScoreOverview sso = new StudentScoreOverview();
        sso.setId(ss.getId());
        sso.setName(ss.getName());
        sso.setSex(ss.getSex());
        sso.setGrade(ss.getGrade());
        sso.setMajorName(ss.getMajorId());
        sso.setSchoolName(ss.getSchoolId());
        sso.setCourseId(ss.getCourseId());
        sso.setScore(ss.getScore());
        return sso;
    }

    private List<StudentScoreOverview> overviewTransfer(List<StudentScore> ssList){
        List<StudentScoreOverview> transferList = new LinkedList<>();
        for(StudentScore ss : ssList){
            transferList.add(overviewTransfer(ss));
        }
        return transferList;
    }


}
