package com.example.demo.sevice;


import com.example.demo.entity.Student;
import com.example.demo.repository.IStudentRepository;
import com.example.demo.repository.StudentRepository;

import java.util.List;

public class StudentSevice implements IStudentSevice {
    private static IStudentRepository iStudentRepository= new StudentRepository();
    @Override
    public List<Student> findAll() {
return  iStudentRepository.findAll();
    }
}
