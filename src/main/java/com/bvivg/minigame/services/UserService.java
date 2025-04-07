package com.bvivg.minigame.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.bvivg.minigame.entities.User;
import com.bvivg.minigame.repositories.UserRepository;

public class UserService extends BaseService<User> {
    @Autowired
  private UserRepository userRepository;
  public User findByUsername(String username) {
    return userRepository.findByUsername(username);
  }
}
