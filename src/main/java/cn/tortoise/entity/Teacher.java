package cn.tortoise.entity;

import java.util.Date;
import java.util.Objects;

public class Teacher {
    private String id;
    private boolean sex;
    private String name;
    private String schoolId;
    private String password;
    private Date loginDate;

    public Teacher() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id='" + id + '\'' +
                ", sex=" + sex +
                ", name='" + name + '\'' +
                ", schoolId='" + schoolId + '\'' +
                ", password='" + password + '\'' +
                ", loginDate=" + loginDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return sex == teacher.sex &&
                id.equals(teacher.id) &&
                name.equals(teacher.name) &&
                schoolId.equals(teacher.schoolId) &&
                password.equals(teacher.password) &&
                loginDate.equals(teacher.loginDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sex, name, schoolId, password, loginDate);
    }
}
