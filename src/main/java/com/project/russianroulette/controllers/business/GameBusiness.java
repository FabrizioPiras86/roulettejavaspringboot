package com.project.russianroulette.controllers.business;

import com.project.russianroulette.entities.Game;
import com.project.russianroulette.entities.User;
import com.project.russianroulette.service.GameService;
import com.project.russianroulette.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameBusiness {

    @Autowired
    private GameService gameService;

    @Autowired
    private UserService userService;

    public Game createGame(Game game) {
        User user = game.getUser();
        if (user.getBalance() >= game.getBetAmount()) {
            user.setBalance(user.getBalance() - game.getBetAmount());
            userService.updateUser(user);
            return gameService.saveGame(game);
        } else {
            throw new IllegalArgumentException("Insufficient balance");
        }
    }

    public List<Game> getGamesByUserId(Long userId) {
        return gameService.findByUserId(userId);
    }
}
