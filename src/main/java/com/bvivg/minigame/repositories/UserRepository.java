package com.bvivg.minigame.repositories;


import com.bvivg.minigame.entities.User;

public interface UserRepository extends BaseRepository<User>{
  User findByUsername(String username);
}