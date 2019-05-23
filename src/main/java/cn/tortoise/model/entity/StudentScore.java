package cn.tortoise.model.entity;

import cn.tortoise.enums.Sex;

/**
 * 选择了某一门课程的某个学生的信息
 */
public class StudentScore {
    // 学生ID
    private String id;
    // 学生性别
    private Sex sex;
    // 学生姓名
    private String name;
    // 学生年级（编码后）
    private String grade;
    // 学生专业编号
    private String majorId;
    // 学生学院编号
    private String schoolId;
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

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
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
        return "StudentScore{" +
                "id='" + id + '\'' +
                ", sex=" + sex +
                ", name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                ", majorId='" + majorId + '\'' +
                ", schoolId='" + schoolId + '\'' +
                ", courseId='" + courseId + '\'' +
                ", score='" + score + '\'' +
                '}';
    }
}
