package com.example.cart.dao;

import com.example.cart.entity.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishListDAO extends JpaRepository<WishList, Integer> {
}
