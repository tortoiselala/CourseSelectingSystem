package cn.tortoise.web;

import cn.tortoise.constant.CommonConstant;
import cn.tortoise.model.dto.LimitAndOffset;
import cn.tortoise.model.dto.RequestResult;
import cn.tortoise.model.dto.StudentScoreOverview;
import cn.tortoise.model.dto.TeacherCourseOverview;
import cn.tortoise.model.entity.Course;
import cn.tortoise.model.entity.User;
import cn.tortoise.service.CourseService;
import cn.tortoise.service.TeacherService;
import cn.tortoise.utils.DateUtil;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Date;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    private final
    CourseService courseService;

    private final
    TeacherService teacherService;

    public TeacherController(CourseService courseService, TeacherService teacherService) {
        this.courseService = courseService;
        this.teacherService = teacherService;
    }

    @RequestMapping(
            value = "/courseList",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"}
    )
    public @ResponseBody
    RequestResult<List<TeacherCourseOverview>> getPublishedCourseList(HttpServletRequest servletRequest){
        User user = null;
        try{
            user = check(servletRequest);
        } catch (Exception e) {
            return new RequestResult<>(false, e.getMessage());
        }

        LimitAndOffset limitAndOffset = new LimitAndOffset(servletRequest);
        int limit = limitAndOffset.getLimit();
        int offset = limitAndOffset.getOffset();
        List<TeacherCourseOverview> list = teacherService.getPublishedCourseListById(user.getUsername(), offset, limit);
        if(list != null){
            System.out.println(list);
            return new RequestResult<>(true, list);
        }

        return new RequestResult<List<TeacherCourseOverview>>(true, new ArrayList<TeacherCourseOverview>());
    }

    @RequestMapping(
            value = "/courseCount",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public @ResponseBody
    RequestResult<Integer> getCourseCount(HttpServletRequest request){
        User user = null;
        try{
            user = check(request);
        } catch (Exception e) {
            return new RequestResult<>(false, e.getMessage());
        }
        int count = 0;
        try{
            count = teacherService.getPublishedCourseCount(user.getUsername());
        }catch (Exception e){
            count = -1;
            System.out.println(e.getMessage());
            return new RequestResult<>(false, "inner error");
        }
        return new RequestResult<>(true, count);
    }

    @RequestMapping(
            value = "/{courseId}/delete",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"}
    )
    public @ResponseBody RequestResult<List<TeacherCourseOverview>> deleteCourse(@PathVariable("courseId") long courseId, HttpServletRequest servletRequest){
        User user = null;
        try{
            user = check(servletRequest);
        } catch (Exception e) {
            return new RequestResult<>(false, e.getMessage());
        }

        if(teacherService.deleteCourseByCourseId(user.getUsername(), courseId)){
            return new RequestResult<>(true, "");
        }
        return new RequestResult<>(false, "course uncurrect or course does't exist");
    }

    @RequestMapping(
            value = "/addCourse",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"}
    )
    public @ResponseBody
    RequestResult addCourse(HttpServletRequest request){
        Course c = new Course();
        try{
            User user;
            user = check(request);
            String name = request.getParameter("courseName");
            if(name == null){
                throw new IllegalArgumentException("course name can't be null");
            }
            float creditPoint = Float.valueOf(request.getParameter("creditPoint"));
            int maxNumber = Integer.valueOf(request.getParameter("maxNumber"));
            if(maxNumber <= 0 || maxNumber >= 1000){
                throw new IllegalArgumentException("Illegal argument: maxNumber = " + maxNumber);
            }
            Date startTime = DateUtil.parseDate(request.getParameter("startTime"));
            Date endTime = DateUtil.parseDate(request.getParameter("endTime"));
            if(startTime.getTime() >= endTime.getTime()){
                throw new IllegalArgumentException("start time should less than end time.");
            }
            int weeks = Integer.valueOf(request.getParameter("weeks"));
            int days = Integer.valueOf(request.getParameter("days"));
            int classTime = Integer.valueOf(request.getParameter("classTime"));
            int allowGrade = Integer.valueOf(request.getParameter("allowGrade"));
            String detail = request.getParameter("detail");

            c.setName(name);
            c.setTeacherId(user.getUsername());
            c.setCreditHours(24);
            c.setCreditPoint(creditPoint);
            c.setMaxNumber(maxNumber);
            c.setCurrentNumber(0);
            c.setStartTime(startTime);
            c.setEndTime(endTime);
            c.setDays(days);
            c.setWeeks(weeks);
            c.setClassTime(classTime);
            c.setAllowGrade(allowGrade);
            c.setDetail(detail);
            int result = teacherService.addNewCourse(c);
            if(result <= 0){
                return new RequestResult(false, "can't add new course");
            }
        }catch(Exception e){
            return new RequestResult(false, e.getMessage());
        }
        return new RequestResult<>(true, c.getId());
    }

    @RequestMapping(
            value = "/{courseId}/studentList",
            method = RequestMethod.GET
    )
    public String getStudentListWhoChosenTargetCourse(
            @PathVariable("courseId")long courseId, HttpServletRequest request, Model model){
        User user;
        List<StudentScoreOverview> list = new LinkedList<>();
        TeacherCourseOverview course = null;
        try{
            user = check(request);
            list = teacherService.getStudentOverviewByCourseId(user.getUsername(), courseId);
            course = teacherService.getPublishedCourseByCourseIdAndTeacherId(courseId, user.getUsername());
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute(CommonConstant.STUDENT_LIST, list);
        model.addAttribute(CommonConstant.COURSE, course);
        return "teacher/course";
    }
    @RequestMapping(
            value = "/updateScore",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"}
    )
    public @ResponseBody
    RequestResult updateScore(HttpServletRequest request){
        User user = null;
        String studentId;
        int score;
        boolean result;
        long courseId;

        try{
            user = check(request);
            studentId = request.getParameter(CommonConstant.STUDENT_ID);
            score = Integer.parseInt(request.getParameter(CommonConstant.SCORE));

            courseId  = Long.parseLong(request.getParameter(CommonConstant.COURSE_ID));

            if(studentId == null){
                throw new IllegalArgumentException("can't find student id");
            }

            result = teacherService.updateScore(studentId, user.getUsername(), courseId, score);
        } catch (Exception e) {
            return new RequestResult<>(false, e.getMessage());
        }
TeacherCourseOverview course;   course = teacherService.getPublishedCourseByCourseIdAndTeacherId(courseId, user.getUsername());
        if(!result){
            return new RequestResult(false, "update false");
        }

        return new RequestResult(true, "");
    }

    private User check(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(CommonConstant.USER_CONTEXT);
        if (user == null) {
            throw new Exception("please login first");
        }

        if (user.isStudent()) {
            throw new Exception("you don't have permission");
        }
        return user;
    }
}
