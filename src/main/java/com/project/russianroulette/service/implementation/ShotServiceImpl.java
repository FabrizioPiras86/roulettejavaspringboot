package com.project.russianroulette.service.implementation;

import com.project.russianroulette.entities.Shot;
import com.project.russianroulette.repository.ShotRepository;
import com.project.russianroulette.service.ShotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShotServiceImpl implements ShotService {

    @Autowired
    private ShotRepository shotRepository;

    @Override
    public Shot saveShot(Shot shot) {
        return shotRepository.save(shot);
    }

    @Override
    public List<Shot> findByGameId(Long gameId) {
        return shotRepository.findByGameId(gameId);
    }
}
