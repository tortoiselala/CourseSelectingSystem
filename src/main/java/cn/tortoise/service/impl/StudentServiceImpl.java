package cn.tortoise.service.impl;

import cn.tortoise.dao.StudentDao;
import cn.tortoise.entity.User;
import cn.tortoise.exceptions.IllegalArgumentCheckedException;
import cn.tortoise.service.StudentService;
import cn.tortoise.utils.PasswordHandler;
import cn.tortoise.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentDao studentDao;

    @Override
    public boolean authCheck(User user) throws IllegalArgumentCheckedException {
        UserUtil.userParmCheck(user);
        return studentDao.getPasswordById(user.getUsername()).equals(PasswordHandler.encryption(user.getPassword()));
    }
}
