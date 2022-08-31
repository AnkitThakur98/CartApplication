package com.example.cart.dao;

import com.example.cart.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseDAO extends JpaRepository<Course, Integer> {
}
