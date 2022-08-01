package com.example.cart.dao;

import com.example.cart.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {
//    @Query("SELECT u FROM User u WHERE u.email = :email")
//    public Optional<User> getUserByEmail(@Param("email") String email);
}
