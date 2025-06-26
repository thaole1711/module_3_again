package Repository;

import Entity.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
}
