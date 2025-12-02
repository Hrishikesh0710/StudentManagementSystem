package com.controller;

import com.dao.StudentDAO;
import com.model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/update-student")
public class UpdateStudent extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        String fn = req.getParameter("firstName");
        String ln = req.getParameter("lastName");
        String email = req.getParameter("email");

        Student s = new Student();
        s.setStudentId(id);
        s.setFirstName(fn);
        s.setLastName(ln);
        s.setEmail(email);

        boolean updated = new StudentDAO().updateStudent(s);

        if (updated) {
            req.setAttribute("successMsg", "Student details updated successfully!!!");
            req.setAttribute("student", s); 

            RequestDispatcher rd = req.getRequestDispatcher("edit-student.jsp");
            rd.forward(req, resp);

        } else {
            req.setAttribute("errorMsg", "Error updating student!");
            RequestDispatcher rd = req.getRequestDispatcher("edit-student.jsp");
            rd.forward(req, resp);
        }
    }
}
