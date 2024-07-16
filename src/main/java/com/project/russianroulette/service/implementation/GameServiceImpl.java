package com.project.russianroulette.service.implementation;

import com.project.russianroulette.entities.Game;
import com.project.russianroulette.repository.GameRepository;
import com.project.russianroulette.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;

    @Override
    public List<Game> findByUserId(Long userId) {
        return gameRepository.findByUserId(userId);
    }

    @Override
    public Game saveGame(Game game) {
        return gameRepository.save(game);
    }

    @Override
    public Game findById(Long gameId) {
        Optional<Game> game = gameRepository.findById(gameId);
        return game.orElse(null);
    }

    @Override
    public void updateGame(Game game) {
        gameRepository.save(game);
    }

}