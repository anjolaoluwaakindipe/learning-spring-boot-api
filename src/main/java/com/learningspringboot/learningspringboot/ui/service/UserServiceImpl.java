package com.learningspringboot.learningspringboot.ui.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.learningspringboot.learningspringboot.ui.User;
import com.learningspringboot.learningspringboot.ui.shared.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    Map<String, User> users;
    Utils utils;

    public UserServiceImpl() {
    }

    @Autowired
    public UserServiceImpl(Utils utils) {
        this.utils = utils;
    }

    @Override
    public User createUser(User userDetail) {
        User newUser = new User();
        newUser.setEmail(userDetail.getEmail());
        newUser.setFirstName(userDetail.getFirstName());
        newUser.setLastName(userDetail.getLastName());
        newUser.setPassword(userDetail.getPassword());

        if (users == null)
            users = new HashMap<>();

        String userId = utils.generateUserId();
        newUser.setUserId(userId);

        users.put(userId, newUser);

        return newUser;
    }
}
