package com.education.servlet;

import com.education.ApplicationStorage;
import com.education.Constant;
import com.education.model.User;
import com.education.sharedContext.SimpleValue;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import static com.education.Constant.STORAGE_ATTRIBUTE;

@WebServlet(name = "addServlet", urlPatterns = "/user/add")
public class AddUserServlet extends HttpServlet {
    private AtomicInteger displayPageCounter = new AtomicInteger(0);
    private ApplicationStorage appStorage;

    @Override
    public void init() throws ServletException {
        super.init();
        appStorage = (ApplicationStorage) getServletContext().getAttribute(STORAGE_ATTRIBUTE);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User user = new User(name, phone, email, password);
        appStorage.addUser(user);
        int totalView = displayPageCounter.addAndGet(1);
        req.setAttribute("totalView", new SimpleValue(totalView));
        req.setAttribute("userFromBack", user);
        req.getRequestDispatcher(Constant.DISPLAY_USER_PAGE).forward(req, resp);
    }
}
