package cn.tortoise.web;

import cn.tortoise.constant.CommonConstant;
import cn.tortoise.model.dto.RequestResult;
import cn.tortoise.model.entity.User;
import cn.tortoise.exceptions.IllegalArgumentCheckedException;
import cn.tortoise.service.CourseService;
import cn.tortoise.service.StudentService;
import cn.tortoise.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class LoginController {

    @Autowired
    StudentService studentService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    CourseService courseService;

    @RequestMapping(value = "/login",
            method = {RequestMethod.POST},
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})

    public @ResponseBody RequestResult<Boolean> login(HttpServletRequest request) {
        String username;
        String password;
        boolean student;

        try {
            username = request.getParameter("username");
            password = request.getParameter("password");
            student = Boolean.valueOf(request.getParameter("student"));
            User user = new User(username, password, student);
            try {
                if (user.isStudent()) {
                    if (studentService.authCheck(user)) {
                        request.getSession().setAttribute(CommonConstant.USER_CONTEXT, user);
                        return new RequestResult<>(true, true);
                    }
                }else{
                    if (teacherService.authCheck(user)) {
                        request.getSession().setAttribute(CommonConstant.USER_CONTEXT, user);
                        return new RequestResult<>(true, true);
                    }
                }
            } catch (IllegalArgumentCheckedException e) {
                System.out.println(e.getMessage());
               // wrong
                // wrong
            }
        } catch (Exception e) {
            // wrong request parameter
        }
        return new RequestResult<>(false, "wrong username or password");
    }

    @RequestMapping(value = "/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response){
        request.getSession().setMaxInactiveInterval(0);
        try {
            response.sendRedirect("/index.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
