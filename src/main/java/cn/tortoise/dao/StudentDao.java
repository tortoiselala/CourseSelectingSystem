package cn.tortoise.dao;
import cn.tortoise.model.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface StudentDao {
    /**
     * 根据id查找密码
     * @param id 学生id
     * @return 查询结果
     */
    String getPasswordById(String id);

    /**
     * 根据id更新最近登录信息
     * @param id 学生id
     * @param date 要更新的日期
     * @return 操作结果
     */
    int updateLoginDateById(@Param("id")String id, @Param("date") Date date);

    /**
     * 获取学生信息
     * @param id 学生id
     * @return 学生信息
     */
    Student getStudentById(String id);
}
