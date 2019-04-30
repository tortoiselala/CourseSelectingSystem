package cn.tortoise.service.impl;

import cn.tortoise.dao.StudentDao;
import cn.tortoise.dao.TeacherDao;
import cn.tortoise.entity.User;
import cn.tortoise.exceptions.IllegalArgumentCheckedException;
import cn.tortoise.service.TeacherService;
import cn.tortoise.utils.PasswordHandler;
import cn.tortoise.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherDao teacherDao;

    @Override
    public boolean authCheck(User user) throws IllegalArgumentCheckedException {
        UserUtil.userParmCheck(user);
        return teacherDao.getPasswordById(user.getPassword()).equals(PasswordHandler.encryption(user.getPassword()));
    }
}