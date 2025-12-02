package com.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDAO;
import com.model.Student;

import java.io.IOException;
import java.util.List;

@WebServlet("/view-students")
public class ViewStudents extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<Student> students = new StudentDAO().getAllStudents();

        req.setAttribute("studentsList", students);

        req.getRequestDispatcher("students-list.jsp").forward(req, resp);
    }
}
