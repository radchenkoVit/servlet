package com.education.filters;

import com.education.Constant;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(servletNames = {"addServlet", "deleteServlet", "logoutServlet"})
public class AutorizationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);

        if(session.getAttribute(Constant.SESSION_IS_USER_ACTIVE_ATTR_NAME) == null || !session.getAttribute(Constant.SESSION_IS_USER_ACTIVE_ATTR_NAME).equals("true")) {
            session.invalidate();//TODO: should be?
            resp.sendRedirect(Constant.LOGIN_PAGE);
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
