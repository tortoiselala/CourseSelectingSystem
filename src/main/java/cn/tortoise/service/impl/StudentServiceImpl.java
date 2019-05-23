package cn.tortoise.service.impl;

import cn.tortoise.dao.CourseDao;
import cn.tortoise.dao.StudentDao;
import cn.tortoise.model.dto.SelectedCourseOverview;
import cn.tortoise.model.entity.User;
import cn.tortoise.exceptions.IllegalArgumentCheckedException;
import cn.tortoise.service.StudentService;
import cn.tortoise.utils.PasswordHandler;
import cn.tortoise.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final
    StudentDao studentDao;

    private final
    CourseDao courseDao;

    @Autowired
    public StudentServiceImpl(StudentDao studentDao, CourseDao courseDao) {
        this.studentDao = studentDao;
        this.courseDao = courseDao;
    }

    @Override
    public boolean authCheck(User user) throws IllegalArgumentCheckedException {
        UserUtil.userParmCheck(user);
        return studentDao.getPasswordById(user.getUsername()).equals(PasswordHandler.encryption(user.getPassword()));
    }

    @Override
    public int getCourseNum() {
        return courseDao.getCourseNum();
    }

    @Override
    public List<SelectedCourseOverview> getSelectedCourseList(String studentId, int offset, int limit) {
        return courseDao.getSelectedCourseOverviewByStudentIdUsingOffsetAndLimit(studentId, offset, limit);
    }

    @Override
    public int getSelectedCourseCount(String studentId) {
        return courseDao.getSelectedCourseCountByStudentId(studentId);
    }
}
