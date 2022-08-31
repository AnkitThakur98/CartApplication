package com.example.cart.service;

import com.example.cart.dao.CourseDAO;
import com.example.cart.dao.UserDAO;
import com.example.cart.dao.WishListDAO;
import com.example.cart.dto.CartResponseDTO;
import com.example.cart.dto.WishListResponseDTO;
import com.example.cart.entity.Cart;
import com.example.cart.entity.Course;
import com.example.cart.entity.User;
import com.example.cart.entity.WishList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class WishListService {
    private static final Logger log = LogManager.getLogger(WishListService.class);

    @Autowired
    WishListDAO wishListDAO;
    @Autowired
    UserDAO userDAO;
    @Autowired
    CourseDAO courseDAO;

    public WishList createWishList(){
        log.info("Entering WishListService createWishList() method");
        WishList wishList = new WishList();
        return wishListDAO.save(wishList);
    }

    public WishListResponseDTO getWishListByUserId(Integer userId){
        log.info("Entering WishListService getWishListByUserId() method");
        User user = userDAO.findById(userId).orElse(null);
        if(user != null) {
            WishList wishList = user.getWishList();
            return wishListEntityToResponseDTOMapper(wishList);
        }
        return null;
    }

    public WishListResponseDTO addCourseToWishList(Integer userId, Integer courseId){
        log.info("Entering WishListService addCourseToWishList() method");
        User user = userDAO.findById(userId).orElse(null);
        Course course = courseDAO.findById(courseId).orElse(null);
        if(user != null){
            WishList wishList = user.getWishList();
            if(course != null){
                if(!wishList.getWishListCourses().isEmpty()) {
                    log.info("WishList has courses" + wishList.getWishListCourses());
                    wishList.getWishListCourses().add(course);
                }
                else{
                    log.info("WishList doesn't have courses");
                    Set<Course> courses = wishList.getWishListCourses();
                    courses.add(course);
                    wishList.setWishListCourses(courses);
                }
                WishList savedWishList = wishListDAO.save(wishList);
                return wishListEntityToResponseDTOMapper(savedWishList);
            }
            else{
                return wishListEntityToResponseDTOMapper(wishList);
            }
        }
//        else{
//            throw UserNotExistsException.;
//        }
        return null;
    }
//
//    public boolean removeCourseFromWishList(Integer wishListId, Integer courseId){
//        log.info("Entering WishListService removeCourseFromWishList() method");
//    }
//
//    public WishList moveToCart(Integer wishListId, Integer cartId, Integer courseId){
//        log.info("Entering WishListService moveToCart() method");
//    }

    public WishListResponseDTO wishListEntityToResponseDTOMapper(WishList wishList){
        WishListResponseDTO wishListResponseDTO = new WishListResponseDTO();
        wishListResponseDTO.setId(wishList.getId());
        wishListResponseDTO.setWishListCourses(wishList.getWishListCourses());

        return wishListResponseDTO;
    }
}
