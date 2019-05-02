package cn.tortoise.utils;

import cn.tortoise.entity.Student;
import cn.tortoise.entity.Teacher;

import java.io.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * 用于生成用户的信息
 */
public class UserAutoGenerator {
    private static final int NUM = 10000;

    private static final String[] YEAR = {
            "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019"
    };
    private Random rand;

    private UserAutoGenerator() {
        rand = new Random(new Date().getTime());
    }

    private List<Student> generateStudents() {
        List<Student> list = new LinkedList<>();
        for(int i = 0; i < NUM; ++i){
            list.add(generateStudent());
        }
        return list;
    }

    private Student generateStudent() {
        Student stu = new Student();
        stu.setId(stringAutoGenerator());
        stu.setName(stu.getId());
        stu.setSex(booleanAutoGenerator());
        stu.setGrade(gradeAutoGenerator());
        stu.setPassword(stu.getId());
        stu.setMajorId(majorIdAutoGenerator());
        stu.setSchoolId(schoolAutoGenerator());
        stu.setLoginDate(new Date());
        return stu;
    }

    private String stringAutoGenerator() {
        StringBuilder sb = new StringBuilder("U");
        int randInt = 0;
        while (randInt == 0) {
            randInt = rand.nextInt();
        }
        sb.append(String.format("%09d", randInt < 0 ? -randInt : randInt));
        String username = sb.toString();
        return username.length() > 10 ? username.substring(0, 10) : username;
    }

    private boolean booleanAutoGenerator() {
        return rand.nextBoolean();
    }

    private String gradeAutoGenerator() {
        int pos = rand.nextInt();
        pos = pos < 0 ? -pos : pos;
        pos %= YEAR.length;
        return YEAR[pos];
    }

    private String majorIdAutoGenerator() {
        return "1000";
    }

    private String schoolAutoGenerator() {
        return "1000";
    }

    public static void toFile(Student stu, String detailFileName, String studentEntryFileName){
        try {
            FileWriter detailWriter = new FileWriter(detailFileName);
            FileWriter studentEntryWriter = new FileWriter(studentEntryFileName);
            write(detailWriter, studentEntryWriter, stu);
            detailWriter.flush();
            detailWriter.close();
            studentEntryWriter.flush();
            studentEntryWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private static void toFile(List<Student> list, String detailFileName, String studentEntryFileName){
        try {
            FileWriter detailWriter = new FileWriter(detailFileName);
            FileWriter studentEntryWriter = new FileWriter(studentEntryFileName);
            for(Student stu : list) {
                write(detailWriter, studentEntryWriter, stu);
            }
            detailWriter.flush();
            detailWriter.close();
            studentEntryWriter.flush();
            studentEntryWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void write(FileWriter detailWriter, FileWriter studentEntryWriter, Student stu) throws IOException {
        detailWriter.write(
                stu.getId()
                        + "," + stu.getName()
                        + "," + stu.getGrade()
                        + "," + stu.getPassword()
                        + "," + stu.getMajorId()
                        + "," + stu.getSchoolId()
                        + "," + stu.getSchoolId()
                        + "," + (stu.isSex() ? 1 : 0)
                        + "," + DateUtil.toString(stu.getLoginDate())
                        + "\n"
        );
        studentEntryWriter.write(
                stu.getId()
                + "," + stu.getPassword()
                + "\n"
        );
    }

    public static void main(String[] args) {
        toFile(new UserAutoGenerator().generateStudents(), "studentDetail1.txt", "studentEntry1.txt");
        toFile(new UserAutoGenerator().generateStudents(), "studentDetail2.txt", "studentEntry2.txt");
        toFile(new UserAutoGenerator().generateStudents(), "studentDetail3.txt", "studentEntry3.txt");
        toFile(new UserAutoGenerator().generateStudents(), "studentDetail4.txt", "studentEntry4.txt");
        toFile(new UserAutoGenerator().generateStudents(), "studentDetail5.txt", "studentEntry5.txt");
    }

}
