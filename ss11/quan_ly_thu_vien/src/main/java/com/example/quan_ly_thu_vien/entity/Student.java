package com.example.quan_ly_thu_vien.entity;

public class Student {
   int studentId;
   String studentName;
   String birthday;
   String className;

    public Student(int studentId, String studentName, String birthday, String className) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.birthday = birthday;
        this.className = className;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
