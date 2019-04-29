package cn.tortoise.dto;

import java.util.Date;

public class CourseOverview {
    private long id;
    private String name;
    private String teacherName;
    private float creditPoint;
    private int creditHours;
    private int maxNumber;
    private int currentNumber;
    private Date startTime;
    private Date endTime;
    private String days;
    private String weeks;
    private String classTime;
    private String allowGrade;

    public CourseOverview() {
    }

    public CourseOverview(long id, String name, float creditPoint,
                          int creditHours, int maxNumber, int currentNumber,
                          Date startTime, Date endTime) {
        this.id = id;
        this.name = name;
        this.creditPoint = creditPoint;
        this.creditHours = creditHours;
        this.maxNumber = maxNumber;
        this.currentNumber = currentNumber;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void setTransformedProperties(String teacherName, String days,
                                         String weeks, String classTime,
                                         String allowGrade){
        this.teacherName = teacherName;
        this.days = days;
        this.weeks = weeks;
        this.classTime = classTime;
        this.allowGrade = allowGrade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getWeeks() {
        return weeks;
    }

    public void setWeeks(String weeks) {
        this.weeks = weeks;
    }

    public String getClassTime() {
        return classTime;
    }

    public void setClassTime(String classTime) {
        this.classTime = classTime;
    }

    public String getAllowGrade() {
        return allowGrade;
    }

    public void setAllowGrade(String allowGrade) {
        this.allowGrade = allowGrade;
    }


    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", creditPoint=" + creditPoint +
                ", creditHours=" + creditHours +
                ", maxNumber=" + maxNumber +
                ", currentNumber=" + currentNumber +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", days='" + days + '\'' +
                ", weeks='" + weeks + '\'' +
                ", classTime='" + classTime + '\'' +
                ", allowGrade='" + allowGrade + '\'' +
                '}';
    }
}
