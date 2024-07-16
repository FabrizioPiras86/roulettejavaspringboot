package com.project.russianroulette.service;

import com.project.russianroulette.entities.Shot;

import java.util.List;

public interface ShotService {
    Shot saveShot(Shot shot);
    List<Shot> findByGameId(Long gameId);
}
