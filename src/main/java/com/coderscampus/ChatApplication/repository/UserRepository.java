package com.coderscampus.ChatApplication.repository;

import com.coderscampus.ChatApplication.domain.User;
import java.util.ArrayList;

public class UserRepository {

    ArrayList<User> listOfUsers = new ArrayList<User>();

    public void saveUser(User user) {
        listOfUsers.add(user);
    }
}
