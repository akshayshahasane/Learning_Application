package com.example.Learning.Application.controller;

import com.example.Learning.Application.dto.UserDto;
import com.example.Learning.Application.entity.User;
import com.example.Learning.Application.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@Valid @RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
