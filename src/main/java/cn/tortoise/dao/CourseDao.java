package cn.tortoise.dao;

import cn.tortoise.model.dto.SelectedCourseOverview;
import cn.tortoise.model.dto.StudentScoreOverview;
import cn.tortoise.model.dto.TeacherCourseOverview;
import cn.tortoise.model.entity.Course;
import cn.tortoise.model.entity.SelectedCourse;
import cn.tortoise.model.entity.StudentScore;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;


public interface CourseDao {
    /**
     * 增加新的课程
     * @param course 课程信息
     * @return 发布结果
     */
    int addNewCourse(Course course);

    /**
     * 删除课程
     * @param teacherId 教师id
     * @param courseId 课程id
     * @return 删除的行数
     */
    int deleteCourseById(@Param("teacherId")String teacherId, @Param("courseId")long courseId);

    /**
     * 根据课程id获取课程信息
     * @param id 课程id
     * @return 课程信息
     */
    Course getCourseById(long id);

    /**
     * 根据学生id和课程id查询选课记录
     * @param studentId 学生id
     * @param courseId 课程id
     * @return 查询结果
     */
    SelectedCourse getSelectedCourse(@Param("studentId")String studentId, @Param("courseId")long courseId);

    /**
     * 获取课程信息列表
     * @return 课程信息列表
     */
    List<Course> getCourseList();

    /**
     * 获取总的课程数目
     * @return 总数目
     */
    int getCourseNum();

    /**
     * 获取课程信息列表
     * @param offset 返回的课程信息列表偏移量
     * @param limit 返回的课程信息列表长度
     * @return 课程信息列表
     */
    List<Course> getCourseListUsingOffsetAndLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     *  获取某个学生选择的所有课程列表
     *  课程信息是经过转换的可视结果
     * @param id 学生id
     * @param offset 返回的课程信息列表偏移量
     * @param limit 返回的课程信息列表长度
     * @return 课程信息列表
     */
    List<SelectedCourseOverview> getSelectedCourseOverviewByStudentIdUsingOffsetAndLimit(@Param("studentId") String id, @Param("offset") int offset, @Param("limit") int limit);

    /**
     * 获取某一学生选课数目
     * @param studentId 学生id
     * @return 选课数目
     */
    int getSelectedCourseCountByStudentId(String studentId);
    /**
     * 增加某个课程的选课人数 (newValue = oldValue + 1)
     * @param courseId 课程id
     * @return 操作结果
     */
    int increaseCourse(long courseId);

    /**
     * 减少某个某个课程的选课人数 (newValue = oldValue - 1)
     * @param courseId 课程id
     * @return 操作结果
     */
    int decreaseCourse(long courseId);

    /**
     * 在选课表中插入一行选课信息（执行选课操作）
     * @param studentId 学生id
     * @param courseId 课程id
     * @return 插入结果
     */
    int selectCourse(@Param("studentId") String studentId, @Param("courseId") long courseId);

    /**
     * 获取某个教师发布的部分课程列表
     * @param id 教师id60
     * @param offset 课程列表偏移量
     * @param limit 课程列表长度
     * @return 课程列表
     */
    List<TeacherCourseOverview> getPublishedCourseListByTeacherIdUsingOffsetAndLimit(@Param("id")String id, @Param("offset") int offset, @Param("limit")int limit);

    /**
     * 获取某个课程
     * @param courseId 课程id
     * @param teacherId 教师id
     * @return 查询结果
     */
    TeacherCourseOverview getPublishedCourseByCourseIdAndTeacherId(@Param("courseId")long courseId, @Param("teacherId")String teacherId);
    /**
     * 获取某个教师发布的课程总数目
     * @param id 教师id
     * @return 课程数目
     */
    int getPublishedCourseCountById(String id);
    /**
     * 获取选择了某一课程学生列表
     * 学生列表经过了视图转换，
     * @param id 课程id
     * @return 学生列表
     */
    List<StudentScore> getStudentListWhoChosenTargetCourse(long id);

    /**
     * 根据学生id和课程id更新学生相应课程的成绩
     * @param studentId 学生id
     * @param courseId 课程id
     * @param score 新的课程成绩
     * @return 更新结果
     */
    int updateScoreByStudentIdAndCourseId(@Param("studentId")String studentId, @Param("courseId")long courseId, @Param("score")int score);

    /**
     * 根据学生id和课程id删除选课记录
     * @param studentId 学生id
     * @param courseId 课程id
     * @return 操作结果
     */
    int deleteSelectedCourseByStudentIdAndCourseId(@Param("studentId")String studentId, @Param("courseId") long courseId);

    // 满足课程设计要求，增加新的sql语句，仅仅实现接口，不添加到业务逻辑中
    // 1.学生相关
    //  - 统计自己选课数目
    //  - 统计自己选课学分数目
    //  - 成绩排名
    //  - 查找学分排名中指定范围
    //  - 查找学分大于指定值且选课人数比例小于指定值的课程
    //  -
    // 2.教师相关
    //  - 统计平均成绩
    /**
     * 获取某学生选课数目
     * @param studentId 学生id
     * @return 学生选课数目
     */
    int getSelectedCourseNum(String studentId);

    /**
     * 统计学生已选课学分总数
     * @param studentId 学生id
     * @return 已选课学分总数
     */
    double getSelectedCourseCreditPointsCount(String studentId);

    /**
     * 根据成绩将课程排序
     * @param studentId 学生id
     * @param limit limit
     * @param offset offset
     * @return 排序结果
     */
    List<SelectedCourseOverview> getSelectedCourseOverviewOrderByScoreUsingLimit(@Param("studentId")String studentId, @Param("limit") int limit, @Param("offset") int offset);

    /**
     * 将课程信息按照学分排序，选择指定范围
     * @param offset offset
     * @param limit limit
     * @return 查找结果
     */
    List<Course> getCourseListOrderByCreditPointUsingOffsetAndLimit(@Param("offset") int offset, @Param("limit") int limit);
}
