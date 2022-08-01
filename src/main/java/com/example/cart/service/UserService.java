package com.example.cart.service;

import com.example.cart.dao.UserDAO;
import com.example.cart.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class UserService {
    private static final Logger log = LogManager.getLogger(UserService.class);

    @Autowired
    UserDAO userDAO;

    public User createUser(User user){
        log.info("Entering UserService createUser() method");
        User savedUser = (User) userDAO.save(user);
        return savedUser;
    }

    public Optional<User> getUserById(Integer id){
        log.info("Entering UserService getUserById() method");
        Optional<User> retrievedUser = userDAO.findById(id);
        return retrievedUser;
    }

    public User updateUser(User user){
        log.info("Entering UserService getUserById() method");
        User savedUser = (User) userDAO.save(user);
        return savedUser;
    }

    public boolean deleteUser(Integer id){
        log.info("Entering UserService getUserById() method");
        if(userDAO.existsById(id)) {
            userDAO.deleteById(id);
            return true;
        }

        return false;
    }
}
