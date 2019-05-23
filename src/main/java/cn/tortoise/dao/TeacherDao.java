package cn.tortoise.dao;

import cn.tortoise.model.entity.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface TeacherDao {
    /**
     * 根据id获取密码
     * @param id 教师Id
     * @return 密码
     */
    String getPasswordById(String id);

    /**
     * 根据id获取教师名称
     * @param id 教师id
     * @return 名称
     */
    String getNameById(String id);

    /**
     * 获取教师信息
     * @param id 教师id
     * @return 教师信息
     */
    Teacher getTeacherById(String id);

    // update login date
    int updateLoginDateById(@Param("id")String id, @Param("date")Date date);
}
