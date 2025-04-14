package com.bvivg.minigame.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bvivg.minigame.entities.User;
import com.bvivg.minigame.repositories.UserRepository;
@Service
public class UserService extends BaseService<User> {
  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }
  public User findByUsername(String username) {
    return userRepository.findByUsername(username);
  }
}
