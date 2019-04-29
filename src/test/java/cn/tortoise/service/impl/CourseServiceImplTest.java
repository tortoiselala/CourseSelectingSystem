package cn.tortoise.service.impl;

import cn.tortoise.dto.CourseDetail;
import cn.tortoise.dto.CourseOverview;
import cn.tortoise.dto.SelectedCourseOverview;
import cn.tortoise.entity.Course;
import cn.tortoise.entity.SelectedCourse;
import cn.tortoise.exceptions.IllegalArgumentCheckedException;
import cn.tortoise.service.CourseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-*.xml"})
public class CourseServiceImplTest {

    private static final String id = "U000000001";

    @Autowired
    CourseService courseService;

    @Test
    public void getSelectedCourseByStudentId() {
        try {
            List<SelectedCourseOverview> list = courseService.getSelectedCourseByStudentId(id);
            List<SelectedCourseOverview> listUsingOffsetAndLimit = courseService.getSelectedCourseByStudentId(id, 0, 100);
            for(SelectedCourseOverview e : list){
                System.out.println(e);
            }
            for(SelectedCourseOverview e : listUsingOffsetAndLimit){
                System.out.println(e);
            }
        } catch (IllegalArgumentCheckedException e) {
            e.printStackTrace();
        }
    }

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