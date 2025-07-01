package com.example.demo.repository;



import com.example.demo.entity.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
}
