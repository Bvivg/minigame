package com.bvivg.minigame.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bvivg.minigame.entities.BaseEntity;
import com.bvivg.minigame.repositories.BaseRepository;

import jakarta.transaction.Transactional;
public abstract class BaseService<E extends BaseEntity> {

  @Autowired
  protected BaseRepository<E> repository;

  @Transactional
  public E save(E entity) {
    return repository.save(entity); 
  }

  public Optional<E> findById(Long id) {
    return repository.findById(id);
  }

  public List<E> findAll() {
    return repository.findAll();
  }

  @Transactional
  public void deleteById(Long id) {
    repository.deleteById(id);
  }

}