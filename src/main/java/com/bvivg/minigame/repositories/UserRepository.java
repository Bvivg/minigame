package com.bvivg.minigame.repositories;


import org.springframework.stereotype.Repository;

import com.bvivg.minigame.entities.User;

@Repository
public interface UserRepository extends BaseRepository<User>{
  User findByUsername(String username);
}