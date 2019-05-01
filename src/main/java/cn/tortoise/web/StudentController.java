package cn.tortoise.web;

import cn.tortoise.constant.CommonConstant;
import cn.tortoise.dto.CourseDetail;
import cn.tortoise.dto.CourseOverview;
import cn.tortoise.dto.RequestResult;
import cn.tortoise.entity.Course;
import cn.tortoise.exceptions.IllegalArgumentCheckedException;
import cn.tortoise.service.CourseService;
import org.apache.taglibs.standard.tag.common.fmt.RequestEncodingSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping(
        value = "/student"
)
public class StudentController {

    @Autowired
    CourseService courseService;

    @RequestMapping(
            value = "/main",
            method = {
                    RequestMethod.GET, RequestMethod.POST
            }
    )
    public String courseOverviewList(HttpServletRequest request, Model model){
        Integer offset;
        Integer limit;
        try{
            offset = Integer.valueOf(request.getParameter("offset"));
            limit = Integer.valueOf(request.getParameter("limit"));
        }catch(Exception e){
            offset = 0;
            limit = 10;
        }

        List<CourseOverview> list = new LinkedList<>();

        try {
            list = courseService.transformToCourseOverview(courseService.getCourseList(offset, limit));
        } catch (IllegalArgumentCheckedException e) {
            // this should't happen
        }
        model.addAttribute(CommonConstant.COURSE_LIST, list);
        return "student/courseList";
    }

    @RequestMapping(
            value = "/course/{courseId}/detail"
    )
    public String courseDetail(
            @PathVariable("courseId") String courseId,
            HttpServletRequest request,
            Model model
    ){
        Integer courseIdLong;
        CourseDetail detail;
        try{
            detail = courseService.transformToCourseDetail(courseService.getCourseById(Integer.valueOf(courseId)));
        }catch(Exception e){
            detail = new CourseDetail();
        }
        model.addAttribute(CommonConstant.COURSE_DETAIL, detail);
        return "student/courseDetail";
    }

    @RequestMapping(
            value = "/course/{courseId}/select"
    )
    public RequestResult courseSelect(){
        return new RequestResult(false, "");
    }
}
