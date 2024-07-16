
package com.project.russianroulette.controllers.business;

import com.project.russianroulette.entities.Game;
import com.project.russianroulette.entities.Shot;
import com.project.russianroulette.entities.User;
import com.project.russianroulette.service.GameService;
import com.project.russianroulette.service.ShotService;
import com.project.russianroulette.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class ShotBusiness {

    @Autowired
    private ShotService shotService;

    @Autowired
    private GameService gameService;

    @Autowired
    private UserService userService;

    public List<Shot> getShotsByGameId(Long gameId) {
        return shotService.findByGameId(gameId);
    }

    public Shot createShot(Long gameId) {
        Game game = gameService.findById(gameId);
        User user = game.getUser();
        if (game.isActive()) {
            List<Shot> shots = shotService.findByGameId(gameId);
            if (shots.size() < 5) {
                boolean hit = new Random().nextInt(4) == 0; // 25% probabilità di colpo

                Shot shot = new Shot();
                shot.setGame(game);
                shot.setShotNumber(shots.size() + 1);
                shot.setHit(hit);
                shotService.saveShot(shot);

                if (hit) {
                    user.setBalance(user.getBalance() - game.getBetAmount());
                    game.setActive(false);
                } else {
                    game.setBetAmount(game.getBetAmount() * 1.25);
                    if (shots.size() == 4) {
                        user.setBalance(user.getBalance() + game.getBetAmount());
                        game.setActive(false);
                    }
                }

                userService.updateUser(user);
                gameService.updateGame(game);

                return shot;
            }
        }
        return null;
    }

    public void stopGame(Long gameId) {
        Game game = gameService.findById(gameId);
        User user = game.getUser();
        if (game.isActive()) {
            user.setBalance(user.getBalance() + game.getBetAmount());
            game.setActive(false);
            userService.updateUser(user);
            gameService.updateGame(game);
        }
    }
}
