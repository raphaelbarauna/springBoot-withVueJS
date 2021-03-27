package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    private ResponseEntity<List<User>> getAllUser(){

        List<User> users = userRepository.findAll();
        return new ResponseEntity<>(users , HttpStatus.OK);
    }

    @PostMapping("/save")
    private ResponseEntity<User> saveUser(@RequestParam String name, @RequestParam String email, @RequestParam String password){

        User user = new User(name, email, password);
        userRepository.save(user);

        return new ResponseEntity<>(user, HttpStatus.OK);


    }
}
