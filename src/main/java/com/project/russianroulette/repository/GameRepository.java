package com.project.russianroulette.repository;

import com.project.russianroulette.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {
    List<Game> findByUserId(Long userId);
}
