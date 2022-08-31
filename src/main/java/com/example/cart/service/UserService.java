package com.example.cart.service;

import com.example.cart.dao.UserDAO;
import com.example.cart.dto.UserResponseDTO;
import com.example.cart.entity.Cart;
import com.example.cart.entity.User;
import com.example.cart.entity.WishList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private static final Logger log = LogManager.getLogger(UserService.class);

    @Autowired
    UserDAO userDAO;
    @Autowired
    CartService cartService;
    @Autowired
    WishListService wishListService;


    public UserResponseDTO createUser(User user){
        log.info("Entering UserService createUser() method");
        User savedUser = (User) userDAO.save(user);
        if(savedUser != null){
            log.info("Creating cart @ UserService createUser() method");
            Cart cart = cartService.createCart();
            user.setCart(cart);
            WishList wishList = wishListService.createWishList();
            user.setWishList(wishList);
            userDAO.save(user);
        }
        return UserEntityToResponseDTOMapper(savedUser);
    }

    public UserResponseDTO getUserById(Integer id){
        log.info("Entering UserService getUserById() method");
        User retrievedUser = userDAO.findById(id).orElse(null);
        return UserEntityToResponseDTOMapper(retrievedUser);
    }

    public UserResponseDTO updateUser(User user){
        log.info("Entering UserService getUserById() method");
        User updatedUser = user;
        if(userDAO.existsById(user.getId())) {
            updatedUser = (User) userDAO.save(user);
        }
        return UserEntityToResponseDTOMapper(updatedUser);
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
//        userResponseDTO.setId(user.getId());
        userResponseDTO.setEmail(user.getEmail());
        userResponseDTO.setFirstName(user.getFirstName());
        userResponseDTO.setLastName(user.getLastName());
        userResponseDTO.setPhone(user.getPhone());

        return userResponseDTO;
    }
}
