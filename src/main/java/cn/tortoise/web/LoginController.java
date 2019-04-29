package cn.tortoise.web;

import cn.tortoise.entity.Student;
import cn.tortoise.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class LoginController {

    @Autowired
    StudentService studentService;

//    @RequestMapping("/login")
//    public boolean login()


}
