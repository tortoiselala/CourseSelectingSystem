package cn.tortoise.web;

import cn.tortoise.constant.CommonConstant;
import cn.tortoise.model.dto.*;
import cn.tortoise.model.entity.User;
import cn.tortoise.exceptions.ExecuteException;
import cn.tortoise.exceptions.IllegalArgumentCheckedException;
import cn.tortoise.service.CourseService;
import cn.tortoise.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;

/**
 * @author tortoiselala
 */
@Controller
@RequestMapping(
        value = "/student"
)
public class StudentController {

    private final
    CourseService courseService;

    private final
    StudentService studentService;

    @Autowired
    public StudentController(CourseService courseService, StudentService studentService) {
        this.courseService = courseService;
        this.studentService = studentService;
    }

    @RequestMapping(
            value = "/courseList",
            method = {
                    RequestMethod.GET, RequestMethod.POST
            },
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public @ResponseBody
    RequestResult<List<CourseDetail>> courseOverviewList(HttpServletRequest request) {
        int offset;
        int limit;
        try {
            offset = Integer.parseInt(request.getParameter("offset"));
            limit = Integer.parseInt(request.getParameter("limit"));
        } catch (Exception e) {
            offset = 0;
            limit = 10;
        }

        List<CourseDetail> list = new LinkedList<>();

        try {
            list = courseService.transformToCourseDetail(courseService.getCourseList(offset, limit));
        } catch (IllegalArgumentCheckedException e) {
            // this should't happen
        }
        return new RequestResult<>(true, list);
    }


    @RequestMapping(
            value = "/getCourseNum",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public @ResponseBody
    RequestResult<Integer> getCourseNum(){
        return new RequestResult<>(true, studentService.getCourseNum());
    }

    @RequestMapping(
            value = "/course/{courseId}/{md5}/select",
            method = {RequestMethod.POST},
            produces = {"application/json;charset=UTF-8"}
    )
    public @ResponseBody ExecuteResult courseSelect(
            @PathVariable("courseId") Long courseId,
            @PathVariable("md5") String md5,
            HttpServletRequest request
    ) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(CommonConstant.USER_CONTEXT);
        if (user == null) {
            return new ExecuteResult(false, "please login first");
        }
        try {
            return courseService.executeSelection(user.getUsername(), courseId, md5);
        } catch (ExecuteException e) {
            return new ExecuteResult(false, e.getMessage());
        }
    }

    @RequestMapping(
            value = "/selectedCourseList",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public @ResponseBody
    RequestResult getSelectedCourseList(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(CommonConstant.USER_CONTEXT);
        if(user == null){
            return new RequestResult(false, "please login first");
        }
        LimitAndOffset lao = new LimitAndOffset(request);
        List<SelectedCourseOverview> list = studentService.getSelectedCourseList(user.getUsername(), lao.getOffset(), lao.getLimit());
        if(list == null){
            list = new LinkedList<>();
        }
        return new RequestResult<>(true, list);
    }


    @RequestMapping(value = "/course/{courseId}/exposer",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})

    public @ResponseBody
    ExecuteResult exposer(@PathVariable("courseId") Long courseId) {
        return courseService.exportExecuteUrl(courseId);
    }

    @RequestMapping(
            value = "/selectedCourseCount",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public @ResponseBody
    RequestResult getSelectedCount(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(CommonConstant.USER_CONTEXT);
        if(user == null){
            return new RequestResult(false, "please login first");
        }

        LimitAndOffset lao = new LimitAndOffset(request);

        Integer count = studentService.getSelectedCourseCount(user.getUsername());
        return new RequestResult<>(true, count);
    }

    @RequestMapping(
            value = "/deleteCourse",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public @ResponseBody
    RequestResult deleteCourse(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(CommonConstant.USER_CONTEXT);
        if(user == null){
            return new RequestResult(false, "please login first");
        }
        try{
            long courseId = Long.parseLong(request.getParameter("courseId"));
            ExecuteResult result = courseService.decreaseSelectedCourse(user.getUsername(), courseId);
            return new RequestResult(result.isSuccess(), result.getMessage());
        }catch (Exception e){
            return new RequestResult(false, e.getMessage());
        }
    }
}
