package com.project.russianroulette.controllers.business;

import com.project.russianroulette.entities.User;
import com.project.russianroulette.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBusiness {

    @Autowired
    private UserService userService;

    public User getUserByUsername(String username) {
        return userService.findByUsername(username);
    }

    public User createUser(User user) {
        return userService.saveUser(user);
    }
}
