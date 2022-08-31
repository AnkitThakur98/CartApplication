package com.example.cart.dto;

import com.example.cart.entity.Course;

import java.util.Set;

public class WishListResponseDTO {
    private Integer id;
    private Set<Course> wishListCourses;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Course> getWishListCourses() {
        return wishListCourses;
    }

    public void setWishListCourses(Set<Course> wishListCourses) {
        this.wishListCourses = wishListCourses;
    }
}
