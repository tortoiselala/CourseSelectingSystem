package cn.tortoise.service;

import cn.tortoise.model.dto.StudentScoreOverview;
import cn.tortoise.model.dto.TeacherCourseOverview;
import cn.tortoise.model.entity.Course;
import cn.tortoise.model.entity.User;

import java.util.List;

public interface TeacherService {
    /**
     * 教师权限验证
     * @param user 用户信息
     * @return 验证结果
     */
    boolean authCheck(User user);

    /**
     * 获取教师（id）发布的课程列表
     * @param id 教师id
     * @param offset 结果偏移地址
     * @param limit 结果长度
     * @return 查询结果
S
     */
    List<TeacherCourseOverview> getPublishedCourseListById(String id, int offset, int limit);

    /**
     * 教师删除课程（只可以删除自己发布的课程）
     * @param teacherId 教师id
     * @param courseId 要删除的课程id
     * @return 操作结果
     */
    boolean deleteCourseByCourseId(String teacherId, long courseId);

    /**
     * 获取选择某课程的学生的列表
     * @param teacherId 教师id
     * @param courseId 课程id
     * @return 列表
     */
    List<StudentScoreOverview> getStudentOverviewByCourseId(String teacherId, long courseId);

    /**
     * 更新某一学生的成绩
     * 该方法会抛出
     * @param studentId 学生id
     * @param teacherId 教师id
     * @param courseId 课程id
     * @param score 分数
     * @return 更新结果
     */
    boolean updateScore(String studentId, String teacherId, long courseId, int score);

    /**
     * 获取指定教师发布的课程总数目
     * @param teacherId 教师id
     * @return 课程数目
     */
    int getPublishedCourseCount(String teacherId);

    /**
     * 获取单个课程信息
     * @param courseId 课程id
     * @param teacherId 教师id
     * @return 获取到的课程信息
     */
    TeacherCourseOverview getPublishedCourseByCourseIdAndTeacherId(long courseId, String teacherId);

    /**
     * 增加新的课程
     * @param course 课程POJO
     * @return 操作结果
     */
    int addNewCourse(Course course);
}
