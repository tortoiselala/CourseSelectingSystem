package cn.tortoise.service.impl;

import cn.tortoise.model.dto.CourseDetail;
import cn.tortoise.model.dto.CourseOverview;
import cn.tortoise.model.dto.SelectedCourseOverview;
import cn.tortoise.model.entity.Course;
import cn.tortoise.exceptions.IllegalArgumentCheckedException;
import cn.tortoise.service.CourseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-*.xml"})
public class CourseServiceImplTest {

    private static final String id = "U000000001";

    @Autowired
    CourseService courseService;


    @Test
    public void getCourseList() {
        try {
            List<Course> list = courseService.getCourseList();
            for(Course e : list){
                System.out.println(e);
            }

            System.out.println("------------");
            List<Course> listUsingOffsetAndLimit = courseService.getCourseList(2, 1);
            for(Course e : listUsingOffsetAndLimit){
                System.out.println(e);
            }
        } catch (IllegalArgumentCheckedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void transformToCourseOverview() {
        try {
            List<CourseOverview> listOverView = courseService.transformToCourseOverview(courseService.getCourseList());
            for(CourseOverview e : listOverView){
                System.out.println(e);
            }
        } catch (IllegalArgumentCheckedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void transformToCourseDetail() {
        try {
            List<CourseDetail> listDetail = courseService.transformToCourseDetail(courseService.getCourseList());
            for(CourseDetail e : listDetail){
                System.out.println(e);
            }
        } catch (IllegalArgumentCheckedException e) {
            e.printStackTrace();
        }
    }
}