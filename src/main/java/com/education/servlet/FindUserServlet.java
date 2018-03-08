package com.education.servlet;

import com.education.ApplicationStorage;
import com.education.Constant;
import com.education.model.User;
import com.education.sharedContext.SimpleValue;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet(name = "findUserServlet", urlPatterns = "/user/find")
public class FindUserServlet extends HttpServlet {
    private AtomicInteger pageCounter = new AtomicInteger(0);
    private ApplicationStorage applicationStorage;

    @Override
    public void init() throws ServletException {
        super.init();
        applicationStorage = (ApplicationStorage) getServletContext().getAttribute(Constant.STORAGE_ATTRIBUTE);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int totalView = pageCounter.getAndAdd(1);
        req.setAttribute("totalView", new SimpleValue(totalView));
        req.getRequestDispatcher(Constant.FIND_USER_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        Optional<User> oUser = applicationStorage.getAll().stream().filter(user -> user.getEmail().equalsIgnoreCase(email)).findFirst();
        if (oUser != null && oUser.isPresent()) {
            req.setAttribute("userFromBack", oUser.get());
            req.setAttribute("totalView", new SimpleValue(pageCounter.intValue()));
            req.getRequestDispatcher(Constant.DISPLAY_USER_PAGE).forward(req, resp);
        } else {
            Cookie errorMessageCookie = new Cookie("errorMessage", URLEncoder.encode( "User not found", "UTF-8" ));
            errorMessageCookie.setMaxAge(30*60);
            resp.addCookie(errorMessageCookie);
            resp.sendRedirect(Constant.ERROR_PAGE_REDIRECT_URL);
        }
    }
}
