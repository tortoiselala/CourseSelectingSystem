package cn.tortoise.dto;

public class SelectedCourseOverview {
    private long courseId;
    private String courseName;
    private int courseScore;

    public SelectedCourseOverview(long courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseScore = -1;
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

    public int getCourseScore() {
        return courseScore;
    }

    public void setCourseScore(int courseScore) {
        this.courseScore = courseScore;
    }

    @Override
    public String toString() {
        return "SelectedCourseOverview{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseScore=" + courseScore +
                '}';
    }
}
