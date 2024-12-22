package com.coderscampus.ChatApplication.service;

import com.coderscampus.ChatApplication.domain.User;
import com.coderscampus.ChatApplication.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Long createUser(String name) {

        User newUser = new User(name);
        userRepository.addNewUser(newUser);
        return newUser.getUserId();
    }

}
