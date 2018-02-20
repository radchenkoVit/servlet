package com.education.servlet;

import com.education.ApplicationStorage;
import com.education.Constant;
import com.education.exception.NotDeletedException;
import com.education.model.User;
import com.education.sharedContext.SimpleValue;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet(name = "deleteServlet", urlPatterns = "/user/delete")
public class DeleteUserServlet extends HttpServlet {
    private AtomicInteger pageCounter = new AtomicInteger(0);
    private ApplicationStorage applicationStorage;

    @Override
    public void init() throws ServletException {
        super.init();
        applicationStorage = (ApplicationStorage) getServletContext().getAttribute(Constant.STORAGE_ATTRIBUTE);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int totalView = pageCounter.addAndGet(1);
        req.setAttribute("totalView", new SimpleValue(totalView));
        req.getRequestDispatcher(Constant.DELETE_USER_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("userIdToDelete"));

        User deletedUser = null;
        try {
            deletedUser = applicationStorage.deleteUser(userId);
        } catch (NotDeletedException e){
            req.getRequestDispatcher(Constant.DELETE_USER_PAGE).forward(req, resp);
            return;
        }

        req.setAttribute("message", String.format("User with id=%s and name=%s is deleted",
                deletedUser.getId(), deletedUser.getName()));

        req.getRequestDispatcher(Constant.INDEX_PAGE).forward(req, resp);
    }
}
