package com.education;

import com.education.model.User;

import java.util.HashMap;
import java.util.Map;

public class ApplicationStorage {
    private static int counter = 0;
    private Map<Integer, User> userMap = new HashMap<>();

    public synchronized void addUser(User user){
        user.setId(counter);
        userMap.put(counter++, user);
    }

    public synchronized void deleteUser(int id){
        if (userMap.containsKey(id)){
            userMap.remove(id);
        } else {
            throw new RuntimeException("Not found user in storage");
        }
    }

    public User getById(int id){
        return userMap.get(id);
    }
}
