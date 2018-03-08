package com.education.listener;

import com.education.ApplicationStorage;
import com.education.model.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import java.util.Arrays;
import java.util.List;

import static com.education.Constant.STORAGE_ATTRIBUTE;

@WebListener
public class StorageDataListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        ApplicationStorage applicationStorage = new ApplicationStorage();
        addDataToStorage(applicationStorage);
        servletContext.setAttribute(STORAGE_ATTRIBUTE, applicationStorage);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

    private void addDataToStorage(ApplicationStorage storage) {
        List<User> users = generateUsers();
        for (User user: users){
            storage.addUser(user);
        }
    }

    private List<User> generateUsers(){
        User admin = new User("admin", "phone", "email", "admin");
        User user = new User("user1", "phone", "email2", "sadxzczsd");
        User user2 = new User("user2", "phone", "email3", "asdxzcsad");

        return Arrays.asList(admin, user, user2);
    }
}
