package com.education.servlet;

import com.education.ApplicationStorage;
import com.education.Constant;
import com.education.exception.NotDeletedException;
import com.education.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "deleteServlet", urlPatterns = "/user/delete")
public class DeleteUserServlet extends HttpServlet {
    private ApplicationStorage applicationStorage;

    @Override
    public void init() throws ServletException {
        super.init();
        applicationStorage = (ApplicationStorage) getServletContext().getAttribute(Constant.STORAGE_ATTRIBUTE);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("userEmailToDelete");

        User deletedUser = null;
        try {
            deletedUser = applicationStorage.deleteUser(email);
        } catch (NotDeletedException e){
            Cookie errorMessageCookie = new Cookie("errorMessage", URLEncoder.encode( "Wasnot deleted", "UTF-8" ));
            errorMessageCookie.setMaxAge(30*60);
            resp.addCookie(errorMessageCookie);
            resp.sendRedirect(Constant.ERROR_PAGE_REDIRECT_URL);
            return;
        }

        req.setAttribute("message", String.format("User with id=%s and name=%s is deleted",
                deletedUser.getId(), deletedUser.getName()));

        req.getRequestDispatcher(Constant.INDEX_PAGE).forward(req, resp);
    }
}
