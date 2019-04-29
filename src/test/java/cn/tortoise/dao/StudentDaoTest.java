package cn.tortoise.dao;

import cn.tortoise.entity.SelectedCourse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.Date;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})

public class StudentDaoTest {
    private static final String id = "U201614515";
    @Autowired
    StudentDao studentDao;

    @Test
    public void getPassword() {
        Assert.assertTrue("1546191727".equals(studentDao.getPasswordById(id)));
    }

    @Test
    public void updateLoginDate() {
        Assert.assertTrue(studentDao.updateLoginDateById(id, new Date()) == 1);
    }

    @Test
    public void getStudent() {
        System.out.println(studentDao.getStudentById(id));
    }

    @Test
    public void selectCourse() {
        String studentId = "U201614515";
        long courseId = 1001L;
        System.out.println(studentDao.selectCourse(studentId, courseId));
    }

    @Test
    public void getAllSelectedCourseById() {
        String studentId = "U201614515";
        for(SelectedCourse selectedCourse :studentDao.getAllSelectedCourseById(studentId)){
            System.out.println(selectedCourse);
        }
    }
}