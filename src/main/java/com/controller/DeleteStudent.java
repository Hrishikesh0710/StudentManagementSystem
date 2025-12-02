package com.controller;

import com.dao.StudentDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-student")
public class DeleteStudent extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        boolean deleted = new StudentDAO().deleteStudent(id);

        if (deleted)
            resp.sendRedirect("view-students");
        else
            resp.getWriter().println("Error deleting student!");
    }
}
