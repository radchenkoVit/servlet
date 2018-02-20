package com.education.servlet;

import com.education.Constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "logoutServlet", urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //invalidate the session if exists
        HttpSession session = req.getSession(false);
        System.out.println("User="+session.getAttribute("user"));
        session.invalidate();
        resp.sendRedirect("login.jsp");
    }
}
