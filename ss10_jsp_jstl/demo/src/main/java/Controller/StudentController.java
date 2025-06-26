package Controller;

import Entity.Student;
import Sevice.IStudentSevice;
import Sevice.StudentSevice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/hocsinh")
public class StudentController extends HttpServlet {
    private IStudentSevice iStudentSevice = new StudentSevice();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> list = iStudentSevice.findAll();
        req.setAttribute("students", list);
        req.getRequestDispatcher("/view/hocsinh.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
}
