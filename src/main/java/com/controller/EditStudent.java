package com.controller;

import com.dao.StudentDAO;
import com.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/edit-student")
public class EditStudent extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        Student s = new StudentDAO().getStudentById(id);

        req.setAttribute("student", s);

        req.getRequestDispatcher("edit-student.jsp").forward(req, resp);
    }
}
