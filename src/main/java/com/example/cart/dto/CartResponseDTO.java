package com.example.cart.dto;

import com.example.cart.entity.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CartResponseDTO {
    private Integer id;
    private Float totalPrice;
    private List<CourseResponseDTO> cartCourses;

    public CartResponseDTO() {
        this.cartCourses = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<CourseResponseDTO> getCartCourses() {
        return cartCourses;
    }

    public void setCartCourses(CourseResponseDTO cartCourses) {
        this.cartCourses = new ArrayList<>();
        this.cartCourses.add(cartCourses);
    }
}
