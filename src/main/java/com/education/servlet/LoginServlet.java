package com.education.servlet;

import com.education.ApplicationStorage;
import com.education.Constant;
import com.education.helpers.UserSearchHelper;
import com.education.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private ApplicationStorage applicationStorage;

    @Override
    public void init() throws ServletException {
        super.init();
        applicationStorage = (ApplicationStorage) getServletContext().getAttribute(Constant.STORAGE_ATTRIBUTE);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");


        User user = null;
        try {
            user = UserSearchHelper.getUser(applicationStorage, email, password);
        } catch (RuntimeException e) {
            req.setAttribute("message", "FAILED TO LOGIN, REASON: " + e.getMessage());
            req.getRequestDispatcher(Constant.LOGIN_PAGE).forward(req, resp);
            return;
        }

        HttpSession session = req.getSession(true);
        session.setAttribute("user", "WTF");
        //setting session to expiry in 30 mins
        session.setMaxInactiveInterval(30*60);
        Cookie userCookie = new Cookie("user", user.getName());
        userCookie.setMaxAge(30*60);
        resp.addCookie(userCookie);

        resp.sendRedirect("index.jsp");//TODO: why redirect not dispatcher, just cause we added info to session and cookie?
        //why works if index page was moved to web app package
    }
}
