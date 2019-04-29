package cn.tortoise.service;


import cn.tortoise.dto.CourseDetail;
import cn.tortoise.entity.Course;
import cn.tortoise.entity.User;
import cn.tortoise.exceptions.UserParameterErrorException;

import java.util.List;

public interface StudentService {
    // 登录验证
    boolean authCheck(User user) throws UserParameterErrorException;
    //
//    List<CourseDetail>

}
