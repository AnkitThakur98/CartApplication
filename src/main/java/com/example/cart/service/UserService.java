package com.example.cart.service;

import com.example.cart.dao.UserDAO;
import com.example.cart.dto.UserResponseDTO;
import com.example.cart.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private static final Logger log = LogManager.getLogger(UserService.class);

    @Autowired
    UserDAO userDAO;

    public UserResponseDTO createUser(User user){
        log.info("Entering UserService createUser() method");
        User savedUser = (User) userDAO.save(user);
        return UserEntityToResponseDTOMapper(savedUser);
    }

    public UserResponseDTO getUserById(Integer id){
        log.info("Entering UserService getUserById() method");
        User retrievedUser = userDAO.findById(id).orElse(null);
        return UserEntityToResponseDTOMapper(retrievedUser);
    }

    public UserResponseDTO updateUser(User user){
        log.info("Entering UserService getUserById() method");
        User savedUser = (User) userDAO.save(user);
        return UserEntityToResponseDTOMapper(savedUser);
    }

    public boolean deleteUser(Integer id){
        log.info("Entering UserService getUserById() method");
        if(userDAO.existsById(id)) {
            userDAO.deleteById(id);
            return true;
        }

        return false;
    }

    public UserResponseDTO UserEntityToResponseDTOMapper(User user){
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(user.getId());
        userResponseDTO.setEmail(user.getEmail());
        userResponseDTO.setFirstName(user.getFirstName());
        userResponseDTO.setLastName(user.getLastName());
        userResponseDTO.setPhone(user.getPhone());

        return userResponseDTO;
    }
}
