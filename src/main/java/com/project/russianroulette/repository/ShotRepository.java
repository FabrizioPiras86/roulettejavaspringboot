package com.project.russianroulette.repository;

import com.project.russianroulette.entities.Shot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShotRepository extends JpaRepository<Shot, Long> {
    List<Shot> findByGameId(Long gameId);
}
