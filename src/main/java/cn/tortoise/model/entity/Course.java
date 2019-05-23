package cn.tortoise.model.entity;


import java.util.Date;
import java.util.Objects;

public class Course {
    private long id;
    private String name;
    private String teacherId;
    private float creditPoint;
    private int creditHours;
    private int maxNumber;
    private int currentNumber;
    private Date startTime;
    private Date endTime;
    private int days;
    private int weeks;
    private int classTime;
    private int allowGrade;
    private String detail;

    public Course() {
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

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
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

    public int getAllowGrade() {
        return allowGrade;
    }

    public void setAllowGrade(int allowGrade) {
        this.allowGrade = allowGrade;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id == course.id &&
                Float.compare(course.creditPoint, creditPoint) == 0 &&
                creditHours == course.creditHours &&
                maxNumber == course.maxNumber &&
                currentNumber == course.currentNumber &&
                days == course.days &&
                weeks == course.weeks &&
                classTime == course.classTime &&
                allowGrade == course.allowGrade &&
                name.equals(course.name) &&
                teacherId.equals(course.teacherId) &&
                startTime.equals(course.startTime) &&
                endTime.equals(course.endTime) &&
                detail.equals(course.detail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, teacherId, creditPoint, creditHours, maxNumber, currentNumber, startTime, endTime, days, weeks, classTime, allowGrade, detail);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teacherId='" + teacherId + '\'' +
                ", creditPoint=" + creditPoint +
                ", creditHours=" + creditHours +
                ", maxNumber=" + maxNumber +
                ", currentNumber=" + currentNumber +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", days=" + days +
                ", weeks=" + weeks +
                ", classTime=" + classTime +
                ", allowGrade='" + allowGrade + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}
