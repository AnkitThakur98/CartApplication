package com.example.cart.service;

import com.example.cart.dao.CartDAO;
import com.example.cart.dao.CourseDAO;
import com.example.cart.dao.UserDAO;
import com.example.cart.dto.CartResponseDTO;
import com.example.cart.dto.UserResponseDTO;
import com.example.cart.entity.Cart;
import com.example.cart.entity.Course;
import com.example.cart.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CartService {
    private static final Logger log = LogManager.getLogger(CourseService.class);

    @Autowired
    CartDAO cartDAO;
    @Autowired
    UserDAO userDAO;
    @Autowired
    CourseDAO courseDAO;
    @Autowired
    CourseService courseService;

    public Cart createCart(){
        Cart cart = new Cart();
        return (Cart) cartDAO.save(cart);
        //return cartDAO.existsById(cart.getId());
    }

    public CartResponseDTO getCartByUserId(Integer userId) {
        User user = userDAO.findById(userId).orElse(null);
        //log.info("User is " + user);
        if(user != null) {
            //Cart cart = cartDAO.findById(user.getCart().getId()).orElse(null);
            Cart cart = user.getCart();
            //log.info("Cart is " + cart);
            return cartEntityToResponseDTOMapper(cart);
        }
        return null;
    }

    public CartResponseDTO addCourseToCart(Integer userId, Integer courseId) {
        User user = userDAO.findById(userId).orElse(null);
        Course course = courseDAO.findById(courseId).orElse(null);

        if(user != null){
            Cart cart = user.getCart();

            if(course != null){
                if(!cart.getCartCourses().isEmpty()) {
                    //log.info("Cart has courses" + cart);
                    if(!cart.getCartCourses().contains(course)) {
                        cart.getCartCourses().add(course);
                        cart.setTotalPrice(cart.getTotalPrice() + course.getPrice());
                    }
                }

                else{
                    log.info("Cart doesn't have courses");
                    List<Course> courses = cart.getCartCourses();
                    courses.add(course);
                    //cart.setCartCourses(courses);
                    cart.setTotalPrice(course.getPrice());
                }
                Cart savedCart = cartDAO.save(cart);
                return cartEntityToResponseDTOMapper(savedCart);
            }

            else{
                return cartEntityToResponseDTOMapper(cart);
            }
        }
//        else{
//            throw UserNotExistsException.;
//        }
        return null;
    }

    public boolean removeCourseFromCart(Integer userId, Integer courseId) {
        User user = userDAO.findById(userId).orElse(null);
        Course course = courseDAO.findById(courseId).orElse(null);
        if(user != null){
            Cart cart = user.getCart();
            if(course != null && cart.getCartCourses().contains(course)) {
                cart.getCartCourses().remove(course);
                cart.setTotalPrice(cart.getTotalPrice() - course.getPrice());
            }
            else if(course == null){
                log.info("Invalid courseId! Please enter correct courseId.");
                return false;
            }
            else{
                log.info("Cart does not have this course!");
                return false;
            }

            Cart savedCart = cartDAO.save(cart);
            return true;
        }
//        else{
//            throw UserNotExistsException.;
//        }
        return false;
    }
//
//    public Float checkOut(Integer cartId) {
//    }
//
//    public Cart moveToWishList(Integer cartId, Course course) {
//    }

    public CartResponseDTO cartEntityToResponseDTOMapper(Cart cart){
        CartResponseDTO cartResponseDTO = new CartResponseDTO();
        cartResponseDTO.setId(cart.getId());
        cartResponseDTO.setTotalPrice(cart.getTotalPrice());
        //cartResponseDTO.setCartCourses(cart.getCartCourses());
        for(Course course : cart.getCartCourses()) {
            cartResponseDTO.getCartCourses().add(courseService.courseEntityToResponseDTOMapper(course));
        }
        log.info("Total courses in cart = " + cart.getCartCourses().size());
        return cartResponseDTO;
    }
}
