package com.bvivg.minigame.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bvivg.minigame.entities.BaseEntity;


@Repository
public interface BaseRepository<E extends BaseEntity> extends JpaRepository<E, Long> {

}
