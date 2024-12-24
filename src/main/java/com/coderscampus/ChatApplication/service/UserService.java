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

    public Long createUser(String name, String channel) {


        if (userRepository.getUserMap().containsKey(name) &&
                userRepository.getUserMap().get(name).equals(channel)) {
            System.out.println("name already in db!!!");
            return 0L;
        }

        User newUser = new User(name, channel);
        userRepository.addNewUser(newUser);
        return newUser.getUserId();
    }

}
