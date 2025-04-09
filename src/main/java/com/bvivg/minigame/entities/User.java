package com.bvivg.minigame.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")

@Setter
@Getter
public class User extends BaseEntity {
  @Column(name = "username", nullable = false, unique = true)
  protected String username;
  @Column(name = "password", nullable = false)
  protected String password;
  @Column(name = "avatar", nullable = true)
  protected String avatar;
}
