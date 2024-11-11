package com.coderscampus.ChatApplication.service;

import com.coderscampus.ChatApplication.domain.User;
import com.coderscampus.ChatApplication.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  Long userId = 0L;

  //@Autowired
  private UserRepository userRepository = new UserRepository();

  public void createUser(User user, String channel) {

    userId++;
    user.setId(userId);
    user.setChannel(channel);

    userRepository.saveUser(user);
  }



}

