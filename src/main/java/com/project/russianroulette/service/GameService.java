package com.project.russianroulette.service;

import com.project.russianroulette.entities.Game;

import java.util.List;

public interface GameService {
    List<Game> findByUserId(Long userId);
    Game saveGame(Game game);
    Game findById(Long gameId);
    void updateGame(Game game);
}