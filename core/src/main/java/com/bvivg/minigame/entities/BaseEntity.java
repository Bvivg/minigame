package com.bvivg.minigame.entities;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Setter
@Getter
public abstract class BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected Long id;

  @CreationTimestamp
  @Column(name = "created_at", nullable = false, updatable = false)
  protected Date createdAt;

  @CreationTimestamp
  @Column(name = "updated_at")
  protected Date updatedAt;
}
