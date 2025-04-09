package com.bvivg.minigame.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bvivg.minigame.entities.BaseEntity;
import com.bvivg.minigame.services.BaseService;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class BaseController<E extends BaseEntity> {

  @Autowired
  protected BaseService<E> service;

  @GetMapping
  public List<E> findAll() {
    return service.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<E> findById(@PathVariable Long id){
    Optional<E> entity = service.findById(id);
    return entity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping
  public E create(@RequestBody E entity) {
    return service.save(entity);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    service.deleteById(id);
    return ResponseEntity.noContent().build();
  }

}
