package com.education.helpers;

import com.education.ApplicationStorage;
import com.education.exception.AutorizationException;
import com.education.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserSearchHelper {

    public static User getUser(ApplicationStorage storage, String email, String password) throws AutorizationException {
        List<User> users = new ArrayList<>(storage.getAll());

        Optional<User> optionalUser = users.stream().filter(u -> u.getEmail().equalsIgnoreCase(email)).findFirst();

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (user.getPassword().equals(password)){
                return user;
            } else {
                throw new AutorizationException("Wrong Password");
            }
        } else {
            throw new AutorizationException("User is not found");
        }
    }
}
