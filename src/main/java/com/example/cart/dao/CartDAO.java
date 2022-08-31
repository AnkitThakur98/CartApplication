package com.example.cart.dao;

import com.example.cart.entity.Cart;
import com.example.cart.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartDAO extends JpaRepository<Cart, Integer> {
}
