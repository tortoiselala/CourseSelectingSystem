package cn.tortoise.service;

import cn.tortoise.dao.CourseDao;
import cn.tortoise.entity.User;
import cn.tortoise.exceptions.IllegalArgumentCheckedException;
import org.springframework.beans.factory.annotation.Autowired;

public interface TeacherService {
    boolean authCheck(User user) throws IllegalArgumentCheckedException;
}
