package cn.tortoise.model.dto;

import cn.tortoise.enums.Sex;

import java.util.Date;
/**
 * 选择了某一门课程的某个学生的信息,
 * 该实体是cn.tortoise.model.entity.StudentScore的视图转换结果
 * - 编码grade -> 解码grade
 * - 专业id -> 专业名称
 * - 学院id -> 学院名称
 */
public class StudentScoreOverview {
    // 学生ID
    private String id;
    // 学生性别
    private Sex sex;
    // 学生姓名
    private String name;
    // 学生年级（解码后）
    private String grade;
    // 学生专业名称
    private String majorName;
    // 学生学院名称
    private String schoolName;
    // 学生所选课程ID
    private String courseId;
    // 学生所选课程分数
    private String score;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "StudentScoreOverview{" +
                "id='" + id + '\'' +
                ", sex=" + sex +
                ", name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                ", majorName='" + majorName + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", score='" + score + '\'' +
                '}';
    }
}
