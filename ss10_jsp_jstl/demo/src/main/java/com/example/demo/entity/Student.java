package com.example.demo.entity;

public class Student {
    int idStudent;
    String nameStudent;
    String gender;
    double score;

    public Student(int idStudent, String nameStudent, String gender, double score) {
        this.idStudent = idStudent;
        this.nameStudent = nameStudent;
        this.gender = gender;
        this.score = score;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

}