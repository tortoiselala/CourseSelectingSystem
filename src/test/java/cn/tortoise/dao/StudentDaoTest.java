package cn.tortoise.dao;

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
    private static final String id = "U000000001";
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


}