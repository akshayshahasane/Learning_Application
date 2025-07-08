package com.example.Learning.Application.service;

import com.example.Learning.Application.entity.User;

import java.util.List;

public interface UserService {

    User createUser(User user);
    List<User> getAllUsers();
}
