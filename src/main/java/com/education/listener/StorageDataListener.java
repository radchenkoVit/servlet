package com.education.listener;

import com.education.ApplicationStorage;
import com.education.Constant;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import static com.education.Constant.STORAGE_ATTRIBUTE;

@WebListener
public class StorageDataListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute(STORAGE_ATTRIBUTE, new ApplicationStorage());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
