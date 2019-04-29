package cn.tortoise.dao;

import cn.tortoise.entity.Teacher;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class TeacherDaoTest {

    private final String id = "M000000001";

    @Autowired
    TeacherDao teacherDao;

    @Test
    public void getPassword() {
        Assert.assertTrue(teacherDao.getPasswordById(id).equals("11111111"));
    }

    @Test
    public void getTeacher() {
        System.out.println(teacherDao.getTeacherById(id));
    }

    @Test
    public void updateLoginDazte() {
        Assert.assertTrue(teacherDao.updateLoginDateById(id, new Date()) == 1);
    }
}