package com.bvivg.minigame.entities;

import jakarta.persistence.Entity;

@Entity
public class User extends BaseEntity<User> {
  protected String username;
  protected String password;
  protected String avatar;
}
