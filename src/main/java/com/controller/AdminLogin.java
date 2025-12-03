package com.controller;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.dao.AdminDAO;

import java.io.IOException;

@WebServlet("/admin-login")
public class AdminLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        boolean valid = new AdminDAO().validate(username, password);

        if (valid) {
            HttpSession session = req.getSession();
            session.setAttribute("admin", username);
            resp.sendRedirect("index.jsp");

        } else {
        	req.setAttribute("error", "Invalid username or password!");
        	RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
        	rd.forward(req, resp);
        	
        }
    }
}
