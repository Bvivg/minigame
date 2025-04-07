package com.bvivg.minigame.services;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bvivg.minigame.Helpers.FileHelper;
import com.bvivg.minigame.repositories.BaseRepository;

@Service
public class BaseService<T> {
  @Autowired
  protected BaseRepository<T> baseRepository;
  
  public T save(T entity) {
    return baseRepository.save(entity);
  }
  public T findById(Long id) {
    return baseRepository.findById(id).orElse(null);
  }
  public void delete(Long id) {
    baseRepository.deleteById(id);
  }
  private void updateFields(T existingEntity, T entity, boolean isFullUpdate) throws IOException {
    Field[] fields = entity.getClass().getDeclaredFields();
    
    for (Field field : fields) {
        field.setAccessible(true);
        try {
            Object value = field.get(entity);
            if (isFullUpdate || value != null) { 
                Field existingField = existingEntity.getClass().getDeclaredField(field.getName());
                existingField.setAccessible(true);
                             if (value instanceof MultipartFile) {
                    MultipartFile file = (MultipartFile) value;
                    if (!file.isEmpty()) {
                        FileHelper fileHelper = FileHelper.path("/uploads");
                        fileHelper.save(file);
                        existingField.set(existingEntity, fileHelper.path()); 
                    }
                } else {
                    existingField.set(existingEntity, value);
                }
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
  public T update(Long id, T entity) throws IOException {
    T existingEntity = findById(id);
    if (existingEntity != null) {
        updateFields(existingEntity, entity, true); 
        baseRepository.save(existingEntity);
    }
    return existingEntity;
  }
  public T edit(Long id, T entity) throws IOException {
    T existingEntity = findById(id);
    if (existingEntity != null) {
        updateFields(existingEntity, entity, false); 
        baseRepository.save(existingEntity);
    }
    return existingEntity;
  }
  public List<T> findAll() {
    return baseRepository.findAll();
  }
  public long count() {
    return baseRepository.count();
  }

}
