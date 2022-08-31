package com.example.cart.controller;

import com.example.cart.dto.CourseResponseDTO;
import com.example.cart.entity.Course;
import com.example.cart.service.CourseService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {
    private static final Logger log = LogManager.getLogger(CartController.class);

    @Autowired
    CourseService courseService;

    @PostMapping
    public CourseResponseDTO createCourse(@RequestBody Course course){
        log.info("Entering CourseController createCourse() method");
        return courseService.createCourse(course);
    }

    @GetMapping("/{courseId}")
    public CourseResponseDTO getCourse(@PathVariable Integer courseId){
        log.info("Entering CourseController getCourse() method");
        return courseService.getCourse(courseId);
    }
}
