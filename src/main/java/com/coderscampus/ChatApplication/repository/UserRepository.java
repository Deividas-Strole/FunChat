package com.coderscampus.ChatApplication.repository;

import com.coderscampus.ChatApplication.domain.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {

    private final Map <String, String> userMap = new HashMap<>();

    public void addNewUser(User newUser) {
        userMap.put(newUser.getUserName(), newUser.getChannel());
    }

    public Map<String, String> getUserMap() {
        return userMap;
    }


    public String getUserById(Long userId) {
        return userMap.get(userId);
    }
}
