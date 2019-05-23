package cn.tortoise.dao;

import cn.tortoise.model.dto.SelectedCourseOverview;
import cn.tortoise.model.dto.TeacherCourseOverview;
import cn.tortoise.model.entity.Course;
import cn.tortoise.model.entity.SelectedCourse;
import cn.tortoise.model.entity.StudentScore;
import cn.tortoise.utils.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class CourseDaoTest {

    private final long id = 1000;
    private final String teacherId = "M000000007";
    private final String studentId = "U000000001";


    @Autowired
    CourseDao courseDao;

    @Test
    public void addNewCourse() {
        Course course = new Course();
        course.setName("课程101");
        course.setTeacherId("M000000006");
        course.setCreditPoint(2.5f);
        course.setCreditHours(24);
        course.setMaxNumber(100);
        course.setCurrentNumber(0);
        course.setStartTime(DateUtil.parseDatetime("2017-01-01 11:11:11"));
        course.setEndTime(DateUtil.parseDatetime("2019-01-01 11:11:11"));
        course.setDays(3);
        course.setWeeks(1025);
        course.setClassTime(6);
        course.setAllowGrade(1);
        course.setDetail("课程100");
        System.out.println(courseDao.addNewCourse(course));
    }

    @Test
    public void deleteCourseById() {
        System.out.println(courseDao.deleteCourseById(teacherId, 76545));
    }

    @Test
    public void getCourseById() {
        System.out.println(courseDao.getCourseById(id));
    }

    @Test
    public void getCourseListUsingOffsetAndLimit() {
        for (Course course : courseDao.getCourseListUsingOffsetAndLimit(3, 2)) {
            System.out.println(course);
        }
    }

    @Test
    public void getCourseNum() {
        System.out.println(courseDao.getCourseNum());
    }

    @Test
    public void getCourseList() {
        for (Course course : courseDao.getCourseList()) {
            System.out.println(course);
        }
    }


    @Test
    public void getSelectedCourseOverviewByIdUsingOffsetAndLimit() {
        for (SelectedCourseOverview e : courseDao.getSelectedCourseOverviewByStudentIdUsingOffsetAndLimit("U201614515", 0, 100)) {
            System.out.println(e);
        }
    }

    @Test
    public void decreaseCourse() {
        System.out.println("decrease 1005(120): " + courseDao.increaseCourse(1005));
        System.out.println("decrease 1007(1): " + courseDao.increaseCourse(1007));
    }

    @Test
    public void selectCourse() {
        String studentId = "U201614515";
        long courseId = 1001L;
        System.out.println(courseDao.selectCourse(studentId, courseId));
    }

    @Test
    public void getPublishedCourseListByTeacherIdUsingOffsetAndLimit() {
        List<TeacherCourseOverview> list = courseDao.getPublishedCourseListByTeacherIdUsingOffsetAndLimit("M000000001", 100, 20);
        System.out.println(list.size());
        for(TeacherCourseOverview ov : list){
            System.out.println(ov);
        }
    }

    @Test
    public void getStudentListWhoChosenTargetCourse() {
        List<StudentScore> list = courseDao.getStudentListWhoChosenTargetCourse(1005);
        for(StudentScore sc : list){
            System.out.println(sc);
        }
    }

    @Test
    public void updateScoreByStudentIdAndCourseId() {
        int result = courseDao.updateScoreByStudentIdAndCourseId(studentId, id, 50);
        System.out.println("result = " + result);
    }

    @Test
    public void getSelectedCourse() {
        SelectedCourse sc = courseDao.getSelectedCourse(studentId, 200);
        System.out.println(sc);
    }

    @Test
    public void getPublishedCourseCountById() {
        System.out.println("count = " + courseDao.getPublishedCourseCountById(teacherId));
    }

    @Test
    public void getPublishedCourseByCourseIdAndTeacherId() {
        System.out.println(courseDao.getPublishedCourseByCourseIdAndTeacherId(1000, "M000000001"));
    }

    @Test
    public void getSelectedCourseOverviewByStudentIdUsingOffsetAndLimit() {
        for(SelectedCourseOverview s : courseDao.getSelectedCourseOverviewByStudentIdUsingOffsetAndLimit("U000000001", 0, 20)){
            System.out.println(s);
        }
    }
}