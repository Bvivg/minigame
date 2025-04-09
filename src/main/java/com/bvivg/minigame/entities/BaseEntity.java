package com.bvivg.minigame.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Setter
@Getter
public abstract class BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected Long id;

  @Column(name = "created_at", nullable = false, updatable = false)
  protected LocalDateTime created_at;

  @Column(name = "updated_at")
  protected LocalDateTime updated_at;

  @PrePersist
  protected void onCreate() {
    this.created_at = LocalDateTime.now();
    this.updated_at = LocalDateTime.now();
  }

  @PreUpdate
  protected void onUpdate() {
    this.updated_at = LocalDateTime.now();
  }

}
