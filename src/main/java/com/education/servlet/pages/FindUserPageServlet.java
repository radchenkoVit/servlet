package com.education.servlet.pages;

import com.education.Constant;
import com.education.sharedContext.SimpleValue;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet(name = "findUserPageServlet", urlPatterns = "/finduser.html")
public class FindUserPageServlet extends HttpServlet {
    private AtomicInteger pageCounter = new AtomicInteger(0);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int totalView = pageCounter.addAndGet(1);
        req.setAttribute("totalView", new SimpleValue(totalView));
        req.getRequestDispatcher(Constant.FIND_USER_PAGE).forward(req, resp);
    }
}
