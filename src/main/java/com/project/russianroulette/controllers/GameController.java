package com.project.russianroulette.controllers;

import com.project.russianroulette.controllers.business.GameBusiness;
import com.project.russianroulette.controllers.business.ShotBusiness;
import com.project.russianroulette.entities.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/games")
public class GameController {

    @Autowired
    private GameBusiness gameBusiness;

    @PostMapping("/create")
    public ResponseEntity<Game> createGame(@RequestBody Game game) {
        try {
            Game createdGame = gameBusiness.createGame(game);
            return ResponseEntity.ok(createdGame);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Game>> getGamesByUserId(@PathVariable Long userId) {
        List<Game> games = gameBusiness.getGamesByUserId(userId);
        return ResponseEntity.ok(games);
    }
}
