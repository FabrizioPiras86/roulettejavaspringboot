package com.project.russianroulette.service;

import com.project.russianroulette.entities.User;

public interface UserService {
    User findByUsername(String username);
    User saveUser(User user);
    void updateUser(User user);
}
