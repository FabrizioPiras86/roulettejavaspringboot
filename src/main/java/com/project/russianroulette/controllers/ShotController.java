package com.project.russianroulette.controllers;

import com.project.russianroulette.controllers.business.ShotBusiness;
import com.project.russianroulette.entities.Shot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/shots")
public class ShotController {

    @Autowired
    private ShotBusiness shotBusiness;

    @GetMapping("/game/{gameId}")
    public ResponseEntity<List<Shot>> getShotsByGameId(@PathVariable Long gameId) {
        List<Shot> shots = shotBusiness.getShotsByGameId(gameId);
        return ResponseEntity.ok(shots);
    }

    @PostMapping("/game/{gameId}/create")
    public ResponseEntity<Shot> createShot(@PathVariable Long gameId) {
        Shot shot = shotBusiness.createShot(gameId);
        if (shot != null) {
            return ResponseEntity.ok(shot);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/game/{gameId}/stop")
    public ResponseEntity<Void> stopGame(@PathVariable Long gameId) {
        shotBusiness.stopGame(gameId);
        return ResponseEntity.ok().build();
    }
}
