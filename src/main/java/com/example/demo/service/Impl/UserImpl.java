package com.example.demo.service.Impl;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void createUser(){
        User user = new User("Tomas", "Gentile", "tgnt@gmail.com", 42586769);

        userRepository.save(user);
    }

    @Override
    public Optional<User> getUser(Long id){

        return userRepository.findById(id);

    }
}
