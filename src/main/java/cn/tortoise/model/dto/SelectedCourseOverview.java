package cn.tortoise.model.dto;

import java.util.Date;

/**
 * @author tortoiselala
 */
public class SelectedCourseOverview {
    private long courseId;
    private String courseName;
    private String teacherName;
    private float creditPoint;
    private int creditHours;
    private int maxNumber;
    private int currentNumber;
    private Date startTime;
    private Date endTime;
    private int days;
    private int weeks;
    private int classTime;
    private int courseScore;
    private String detail;

    public SelectedCourseOverview() {
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public float getCreditPoint() {
        return creditPoint;
    }

    public void setCreditPoint(float creditPoint) {
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

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getWeeks() {
        return weeks;
    }

    public void setWeeks(int weeks) {
        this.weeks = weeks;
    }

    public int getClassTime() {
        return classTime;
    }

    public void setClassTime(int classTime) {
        this.classTime = classTime;
    }

    public int getCourseScore() {
        return courseScore;
    }

    public void setCourseScore(int courseScore) {
        this.courseScore = courseScore;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "SelectedCourseOverview{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", creditPoint=" + creditPoint +
                ", creditHours=" + creditHours +
                ", maxNumber=" + maxNumber +
                ", currentNumber=" + currentNumber +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", days=" + days +
                ", weeks=" + weeks +
                ", classTime=" + classTime +
                ", courseScore=" + courseScore +
                ", detail='" + detail + '\'' +
                '}';
    }
}
