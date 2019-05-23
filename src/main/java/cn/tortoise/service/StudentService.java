package cn.tortoise.service;


import cn.tortoise.model.dto.SelectedCourseOverview;
import cn.tortoise.model.entity.User;
import cn.tortoise.exceptions.IllegalArgumentCheckedException;

import java.util.List;

public interface StudentService {
    /**
     * 学生登录验证
     * @param user 用户信息
     * @return 验证结果
     * @throws IllegalArgumentCheckedException 参数不合法
     */
    boolean authCheck(User user) throws IllegalArgumentCheckedException;

    /**
     * 获取学生可选课程数量
     * @return 课程数目
     */
    int getCourseNum();

    /**
     * 获取某一学生选择的课程列表
     * @param studentId 学生id
     * @param offset 起始
     * @param limit 范围
     * @return 结果
     */
    List<SelectedCourseOverview> getSelectedCourseList(String studentId, int offset, int limit);

    /**
     * 获取某个学生选课数目
     * @param studentId 学生id
     * @return 数目
     */
    int getSelectedCourseCount(String studentId);

}
