package cn.tortoise.utils;

import cn.tortoise.entity.Course;
import cn.tortoise.entity.Student;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.zip.CheckedOutputStream;

public class CourseAutoGenerator {
    public static final String[] TEACHER_LIST = {
            "M000000001", "M000000002", "M000000003", "M000000004", "M000000005", "M000000006", "M000000007"
    };

    private static final int NUM = 10000;
    private static final float[] CREDIT_POINT = {
        1f, 1.5f, 2f, 2.5f, 3f
    };
    private static final int[] CREDIT_HOURS = {
            24, 36, 52
    };
    private Random rand;

    public CourseAutoGenerator() {
        rand = new Random(new Date().getTime());
    }

    public List<Course> generateCourses() {
        List<Course> list = new LinkedList<>();
        for(int i = 0; i < NUM; ++i){
            list.add(generateCourse());
        }
        return list;
    }

    private Course generateCourse() {
        Course course = new Course();
        String name = stringAutoGenerator();
        course.setName(name);
        course.setTeacherId(TEACHER_LIST[Math.abs(rand.nextInt()) % TEACHER_LIST.length]);
        course.setCreditPoint(CREDIT_POINT[Math.abs(rand.nextInt()) % CREDIT_POINT.length]);
        course.setCreditHours(CREDIT_HOURS[Math.abs(rand.nextInt()) % CREDIT_HOURS.length]);
        course.setMaxNumber(Math.abs(rand.nextInt()) % 200);
        course.setCurrentNumber(0);
        course.setStartTime(DateUtil.parseDate("2018-0-01 01:01:01"));
        course.setEndTime(DateUtil.parseDate("2020-01-01 01:01:01"));
        course.setDays(3);
        course.setWeeks(3);
        course.setAllowGrade(3);
        course.setDetail(name);
        return course;
    }

    private String stringAutoGenerator() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("C%09d", Math.abs(rand.nextInt())));
        String username = sb.toString();
        return username.length() > 10 ? username.substring(0, 10) : username;
    }
    public static void toFile(Course course , String filename){
        try {
            FileWriter writer = new FileWriter(filename);
            write(writer, course);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private static void toFile(List<Course> list, String filename){
        try {
            FileWriter writer = new FileWriter(filename);
            for(Course course : list) {
                write(writer, course);
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private static void write(FileWriter writer, Course course) throws IOException {
        writer.write(
                course.getName()
                        + "," + course.getTeacherId()
                        + "," + course.getCreditPoint()
                        + "," + course.getCreditHours()
                        + "," + course.getMaxNumber()
                        + "," + course.getCurrentNumber()
                        + "," + DateUtil.toString(course.getStartTime())
                        + "," + DateUtil.toString(course.getEndTime())
                        + "," + course.getDays()
                        + "," +course.getWeeks()
                        + "," +course.getClassTime()
                        + "," + course.getAllowGrade()
                        + "," + course.getDetail() + "\n"
        );
    }

    public static void main(String[] args) {
        toFile(new CourseAutoGenerator().generateCourses(), "course1.txt");
        toFile(new CourseAutoGenerator().generateCourses(), "course2.txt");
        toFile(new CourseAutoGenerator().generateCourses(), "course3.txt");
        toFile(new CourseAutoGenerator().generateCourses(), "course4.txt");
    }
}
