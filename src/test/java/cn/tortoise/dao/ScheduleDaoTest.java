package cn.tortoise.dao;

import cn.tortoise.entity.Schedule;
import cn.tortoise.utils.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.unit.DataUnit;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class ScheduleDaoTest {

    private int id = 1;
    @Autowired
    ScheduleDao scheduleDao;

    @Test
    public void getScheduleById() {
        System.out.println(scheduleDao.getScheduleById(id));
    }

    @Test
    public void getAllSchedule() {
        for(Schedule sc : scheduleDao.getAllSchedule()){
            System.out.println(sc);
        }
    }

    @Test
    public void getScheduleListUsingOffsetAndLimit() {
        for(Schedule sc : scheduleDao.getScheduleListUsingOffsetAndLimit(0, 100)){
            System.out.println(sc);
        }
    }

    @Test
    public void insertSchedule() {
        Schedule sc = new Schedule(DateUtil.parseDate("2017-01-01 00:00:00"), DateUtil.parseDate("2018-01-01 00:00:00"));
        System.out.println("result = " + scheduleDao.insertSchedule(sc));
    }

}