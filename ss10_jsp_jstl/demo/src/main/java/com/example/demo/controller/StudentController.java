package com.example.demo.controller;



import com.example.demo.entity.Student;
import com.example.demo.sevice.IStudentSevice;
import com.example.demo.sevice.StudentSevice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet( urlPatterns = "/hocsinh")
public class StudentController extends HttpServlet {
    private IStudentSevice iStudentSevice = new StudentSevice();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> list = iStudentSevice.findAll();
        req.setAttribute("students", list);
        req.getRequestDispatcher("/WEB-INF/view/hocsinh.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
}
