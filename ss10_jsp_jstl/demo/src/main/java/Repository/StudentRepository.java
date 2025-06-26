package Repository;

import Entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private final String SELECT_ALL="select * from students;";
    public List<Student> findAll(){
        List<Student> list= new ArrayList<>();
        try(Connection connection= BaseRepository.getConnectDB();
            PreparedStatement preparedStatement=connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
              int id=  resultSet.getInt("id_student");
              String name=resultSet.getString("name_student");
              String gender=resultSet.getString("gender");
              double score= Double.parseDouble(resultSet.getString("score"));
              list.add(new Student(id,name,gender,score));
            }
        } catch (SQLException e) {
            System.out.println("lỗi kết nối database");
        }
        return list;
    }

}
