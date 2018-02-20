package com.education.helpers;

import com.education.ApplicationStorage;
import com.education.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserSearchHelper {

    public static User getUser(ApplicationStorage storage, String email, String password) {
        List<User> users = new ArrayList<>(storage.getAll());

        Optional<User> foundUser = users.stream().filter(u -> u.getEmail().equalsIgnoreCase(email)).findFirst();

        if (foundUser.isPresent()) {
            User fuser = foundUser.get();
            if (fuser.getPassword().equals(password)){
                return fuser;
            } else {
                throw new RuntimeException("Wrong Password");//TODO change exception
            }
        } else {
            throw new RuntimeException("User is not found");//TODO change exception
        }
    }
}
