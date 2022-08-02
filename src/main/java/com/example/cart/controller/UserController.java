package com.example.cart.controller;

import com.example.cart.dto.UserResponseDTO;
import com.example.cart.entity.User;
import com.example.cart.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    private static final Logger log = LogManager.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @PostMapping
    public UserResponseDTO createUser(@RequestBody User user){
        log.info("Entering UserController createUser() method");
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public UserResponseDTO getUserById(@PathVariable Integer id){
        log.info("Entering UserController getUserById() method");
        return userService.getUserById(id);
    }

    // for updating, user is passed along with id. Else, without id, new user is created.
    @PutMapping
    public UserResponseDTO updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable Integer id){
        return userService.deleteUser(id);
    }
}
