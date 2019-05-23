package cn.tortoise.model.entity;

import cn.tortoise.enums.Sex;

import java.util.Objects;
import java.util.Date;

public class Student {
    private String id;
    private Sex sex;
    private String name;
    private String grade;
    private String password;
    private String majorId;
    private String schoolId;
    private Date loginDate;

    public Student() {
    }

    public Student(String id) {
        this.id = id;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", sex=" + sex +
                ", name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                ", password='" + password + '\'' +
                ", majorId='" + majorId + '\'' +
                ", schoolId='" + schoolId + '\'' +
                ", loginDate=" + loginDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return sex.getIndex() == student.sex.getIndex() &&
                id.equals(student.id) &&
                name.equals(student.name) &&
                grade.equals(student.grade) &&
                password.equals(student.password) &&
                majorId.equals(student.majorId) &&
                schoolId.equals(student.schoolId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sex, name, grade, password, majorId, schoolId);
    }
}
