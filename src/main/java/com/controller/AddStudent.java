package com.controller;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDAO;
import com.model.Student;

import java.io.IOException;

@WebServlet("/add-student")
public class AddStudent extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

   
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");


        Student s = new Student();
        s.setFirstName(firstName);
        s.setLastName(lastName);
        s.setEmail(email);

        
        boolean saved = new StudentDAO().insertStudent(s);

        if (saved) {
        	req.setAttribute("success", "Student Added Successfully!!!");
        	RequestDispatcher rd = req.getRequestDispatcher("add-student.jsp");
        	rd.forward(req, resp);
        }
        else {
            resp.getWriter().println("<h2>Error saving student!</h2>");
        }
    }
}
