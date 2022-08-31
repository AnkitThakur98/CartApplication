package com.example.cart.controller;

import com.example.cart.dto.CartResponseDTO;
import com.example.cart.entity.Cart;
import com.example.cart.entity.Course;
import com.example.cart.service.CartService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/cart")
public class CartController {
    private static final Logger log = LogManager.getLogger(CartController.class);

    @Autowired
    CartService cartService;

    @GetMapping("/getCart/{userId}")    // {userId} is having same name as PathVariable variable name
    public CartResponseDTO getCartByUserId(@PathVariable Integer userId){
        log.info("Entering CartController getCartByUser() method");
        return cartService.getCartByUserId(userId);
    }

    @PostMapping("/{userId}/{courseId}")
    public CartResponseDTO addCourseToCart(@PathVariable Integer userId, @PathVariable Integer courseId){
        log.info("Entering CartController addCourseToCart() method");
        return cartService.addCourseToCart(userId, courseId);
    }

    @DeleteMapping("/{userId}/{courseId}")
    public boolean removeCourseFromCart(@PathVariable Integer userId, @PathVariable Integer courseId){
        log.info("Entering CartController removeCourseFromCart() method");
        return cartService.removeCourseFromCart(userId, courseId);
    }
//
//    @GetMapping(value = "/getPrice")
//    public Float checkOut(@PathVariable Integer cartId){
//        log.info("Entering CartController checkOut() method");
//        return cartService.checkOut(cartId);
//    }
//
//    @PutMapping
//    public Cart moveToWishList(@PathVariable Integer cartId, @RequestBody Course course){
//        log.info("Entering CartController moveToWishList() method");
//        return cartService.moveToWishList(cartId, course);
//    }
}
