package com.education;

import com.education.exception.NotDeletedException;
import com.education.model.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ApplicationStorage {
    private static int counter = 0;
    private Map<Integer, User> userMap = new HashMap<>();

    public synchronized void addUser(User user){
        user.setId(counter);
        userMap.put(counter++, user);
    }

    public synchronized User deleteUser(String email) throws NotDeletedException {
        Optional<User> optionalUser = userMap.values().stream().filter(user -> user.getEmail().equals(email)).findFirst();

        if (optionalUser.isPresent()){
            return userMap.remove(optionalUser.get().getId());
        } else {
            throw new NotDeletedException("Not found user in storage");
        }
    }

    public Collection<User> getAll(){
        return userMap.values();
    }

    public User getById(int id){
        return userMap.get(id);
    }
}
