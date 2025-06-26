package Sevice;

import Entity.Student;
import Repository.IStudentRepository;
import Repository.StudentRepository;

import java.util.List;

public class StudentSevice implements IStudentSevice {
    private static IStudentRepository iStudentRepository= new StudentRepository();
    @Override
    public List<Student> findAll() {
return  iStudentRepository.findAll();
    }
}
