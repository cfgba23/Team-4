package com.example.demo.service;

import com.example.demo.models.User;

import java.util.Optional;

public interface UserService {
     void createUser();
     Optional<User> getUser(Long id);
}
