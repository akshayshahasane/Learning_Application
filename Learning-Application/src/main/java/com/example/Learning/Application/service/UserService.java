package com.example.Learning.Application.service;

import com.example.Learning.Application.dto.UserDto;
import com.example.Learning.Application.entity.User;

import java.util.List;

public interface UserService {

    User createUser(UserDto userDto);
    List<User> getAllUsers();
}
