package com.bvivg.minigame.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bvivg.minigame.services.BaseService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class BaseController<T> {
@Autowired
  protected BaseService<T> service;

  @GetMapping
  public List<T> findAll(){
    return service.findAll();
  }

  @GetMapping("{id}")
  public T findById(Long id){
    return service.findById(id);
  }
  @PostMapping
  public T save(@RequestBody T entity){
    return service.save(entity);
  }
  @PutMapping("{id}")
  public T update(@PathVariable Long id, @RequestBody T entity)throws IOException {
    return service.update(id, entity);
  }
  @PatchMapping("{id}")
  public T edit(@PathVariable Long id, @RequestBody T entity) throws IOException {
    return service.update(id, entity);
  }
  @DeleteMapping("{id}")
  public void delete(@PathVariable Long id) {
    service.delete(id);
  }
}
