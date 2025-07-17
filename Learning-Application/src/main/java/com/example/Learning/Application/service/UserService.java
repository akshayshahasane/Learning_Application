package com.example.Learning.Application.service;

import com.example.Learning.Application.dto.UserDto;
import com.example.Learning.Application.entity.User;


import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(UserDto userDto);
    List<User> getAllUsers();

    Optional<User> findByEmail(String email);

}
