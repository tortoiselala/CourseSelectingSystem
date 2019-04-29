package cn.tortoise.service.impl;

import cn.tortoise.entity.User;
import cn.tortoise.exceptions.UserParameterErrorException;
import cn.tortoise.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Override
    public boolean authCheck(User user) throws UserParameterErrorException {
        return false;
    }
}
