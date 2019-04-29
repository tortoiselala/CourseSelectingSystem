package cn.tortoise.service.impl;

import cn.tortoise.dao.StudentDao;
import cn.tortoise.entity.User;
import cn.tortoise.exceptions.IllegalArgumentCheckedException;
import cn.tortoise.exceptions.UserParameterErrorException;
import cn.tortoise.service.StudentService;
import cn.tortoise.utils.PasswordHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentDao studentDao;

    @Override
    public boolean authCheck(User user) throws IllegalArgumentCheckedException {
        if(user  == null || !user.isStudent()
                || user.getUsername() == null
                || user.getPassword() == null
                || user.getUsername().length() == 0
                || user.getPassword().length() == 0){
            throw new IllegalArgumentCheckedException(user.toString());
        }
        return studentDao.getPasswordById(user.getPassword()).equals(PasswordHandler.encryption(user.getPassword()));
    }
}
