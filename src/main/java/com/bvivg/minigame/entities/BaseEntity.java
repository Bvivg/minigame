package com.bvivg.minigame.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;


@Entity
@Setter
@Getter
public class BaseEntity<T> {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected Long id;
  protected Date created_at;
  protected Date updated_at;

  @PrePersist
  protected void onCreate() {
    this.created_at = new Date(System.currentTimeMillis());
    this.updated_at = new Date(System.currentTimeMillis());
  }

  @PreUpdate
  protected void onUpdate() {
    this.updated_at = new Date(System.currentTimeMillis());
  }
}
