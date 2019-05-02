package cn.tortoise.dao;

import cn.tortoise.dto.SelectedCourseOverview;
import cn.tortoise.entity.Course;
import cn.tortoise.entity.SelectedCourse;
import cn.tortoise.utils.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class CourseDaoTest {

    private final long id = 1000;

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
        course.setStartTime(DateUtil.parseDate("2017-01-01 11:11:11"));
        course.setEndTime(DateUtil.parseDate("2019-01-01 11:11:11"));
        course.setDays(3);
        course.setWeeks(1025);
        course.setClassTime(6);
        course.setAllowGrade(1);
        course.setDetail("课程100");
        System.out.println(courseDao.addNewCourse(course));
    }

    @Test
    public void deleteCourseById() {
        System.out.println(courseDao.deleteCourseById(1001));
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
    public void getSelectedCourseOverviewById() {
        for (SelectedCourseOverview e : courseDao.getSelectedCourseOverviewById("U201614515")) {
            System.out.println(e);
        }
    }

    @Test
    public void getSelectedCourseOverviewByIdUsingOffsetAndLimit() {
        for (SelectedCourseOverview e : courseDao.getSelectedCourseOverviewByIdUsingOffsetAndLimit("U201614515", 0, 100)) {
            System.out.println(e);
        }
    }

    @Test
    public void decreaseCourse() {
        System.out.println("decrease 1005(120): " + courseDao.decreaseCourse(1005));
        System.out.println("decrease 1007(1): " + courseDao.decreaseCourse(1007));
    }

    @Test
    public void selectCourse() {
        String studentId = "U201614515";
        long courseId = 1001L;
        System.out.println(courseDao.selectCourse(studentId, courseId));
    }

    @Test
    public void getSelectedCourseByStudentId() {
        for(SelectedCourse sc : courseDao.getSelectedCourseByStudentId("U000000001")){
            System.out.println(sc);
        }
    }

    @Test
    public void getSelectedCourseByStudentIdUsingOffsetAndLimit() {
        for(SelectedCourse sc : courseDao.getSelectedCourseByStudentIdUsingOffsetAndLimit("U000000001", 1, 2)){
            System.out.println(sc);
        }
    }
}