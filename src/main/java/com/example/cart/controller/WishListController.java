package com.example.cart.controller;

import com.example.cart.dto.WishListResponseDTO;
import com.example.cart.entity.Cart;
import com.example.cart.entity.Course;
import com.example.cart.entity.WishList;
import com.example.cart.service.WishListService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/wishList")
public class WishListController {
    private static final Logger log = LogManager.getLogger(CartController.class);

    @Autowired
    WishListService wishListService;

    @GetMapping("/{userId}")
    public WishListResponseDTO getWishListByUserId(@PathVariable Integer userId){
        log.info("Entering WishListController getWishListByUserId() method");
        return wishListService.getWishListByUserId(userId);
    }

    @PutMapping("/{userId}/{courseId}")
    public WishListResponseDTO addCourseToWishList(@PathVariable Integer userId, @PathVariable Integer courseId){
        log.info("Entering WishListController addCourseToWishList() method");
        return wishListService.addCourseToWishList(userId, courseId);
    }
//
//    @DeleteMapping
//    public boolean removeCourseFromWishList(@PathVariable Integer userId, Integer courseId){
//        log.info("Entering WishListController removeCourseFromWishList() method");
//        return wishListService.removeCourseFromWishList(userId, courseId);
//    }
//
//    @PutMapping
//    public WishList moveToCart(@PathVariable Integer wishListId, @PathVariable Integer cartId, Integer courseId){
//        log.info("Entering WishListController moveToCart() method");
//        return wishListService.moveToCart(wishListId, cartId, courseId);
//    }
}
