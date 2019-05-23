package cn.tortoise.model.entity;

import java.util.Objects;

public class SelectedCourse {
    private String studentId;
    private String courseId;
    private int score;

    public SelectedCourse(String studentId, String courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public SelectedCourse(String studentId, String courseId, int score) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.score = score;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SelectedCourse that = (SelectedCourse) o;
        return score == that.score &&
                studentId.equals(that.studentId) &&
                courseId.equals(that.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, courseId, score);
    }

    @Override
    public String toString() {
        return "SelectedCourse{" +
                "studentId='" + studentId + '\'' +
                ", courseId='" + courseId + '\'' +
                ", score=" + score +
                '}';
    }
}
