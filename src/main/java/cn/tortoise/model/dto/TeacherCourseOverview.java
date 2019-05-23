package cn.tortoise.model.dto;

import cn.tortoise.utils.CourseUtil;

import java.util.Date;

public class TeacherCourseOverview {
    private String id;
    private String name;
    private String creditPoint;
    private int creditHours;
    private int maxNumber;
    private int currentNumber;
    private Date startTime;
    private Date endTime;
    private String days;
    private String weeks;
    private String classTime;
    private String allowGrade;
    private String detail;

    public TeacherCourseOverview() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreditPoint() {
        return creditPoint;
    }

    public void setCreditPoint(String creditPoint) {
        this.creditPoint = creditPoint;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    public int getCurrentNumber() {
        return currentNumber;
    }

    public void setCurrentNumber(int currentNumber) {
        this.currentNumber = currentNumber;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = CourseUtil.decodeDays(days);
    }

    public String getWeeks() {
        return weeks;
    }

    public void setWeeks(int weeks) {
        this.weeks = CourseUtil.decodeWeeks(weeks);
    }

    public String getClassTime() {
        return classTime;
    }

    public void setClassTime(int classTime) {
        this.classTime = CourseUtil.decodeClassTime(classTime);
    }

    public String getAllowGrade() {
        return allowGrade;
    }

    public void setAllowGrade(int allowGrade) {
        this.allowGrade = CourseUtil.decodeAllowGrade(allowGrade);
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "TeacherCourseOverview{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", creditPoint='" + creditPoint + '\'' +
                ", creditHours=" + creditHours +
                ", maxNumber=" + maxNumber +
                ", currentNumber=" + currentNumber +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", days='" + days + '\'' +
                ", weeks='" + weeks + '\'' +
                ", classTime='" + classTime + '\'' +
                ", allowGrade='" + allowGrade + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}
