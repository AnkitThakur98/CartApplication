package com.example.cart.service;

import com.example.cart.dao.CourseDAO;
import com.example.cart.dto.CourseResponseDTO;
import com.example.cart.dto.UserResponseDTO;
import com.example.cart.entity.Course;
import com.example.cart.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    private static final Logger log = LogManager.getLogger(CourseService.class);

    @Autowired
    CourseDAO courseDAO;

    public CourseResponseDTO createCourse(Course course) {
        log.info("Entering CourseService createCourse() method");
        Course savedCourse = courseDAO.save(course);
        return courseEntityToResponseDTOMapper(course);
    }

    public CourseResponseDTO getCourse(Integer courseId) {
        log.info("Entering CourseService getCourse() method");
        Course retrievedCourse = courseDAO.findById(courseId).orElse(null);
        return courseEntityToResponseDTOMapper(retrievedCourse);
    }

    public CourseResponseDTO courseEntityToResponseDTOMapper(Course course){
        CourseResponseDTO courseResponseDTO = new CourseResponseDTO();
        courseResponseDTO.setId(course.getId());
        courseResponseDTO.setTitle(course.getTitle());
        courseResponseDTO.setCreator(course.getCreator());
        courseResponseDTO.setDescription(course.getDescription());
        courseResponseDTO.setDuration(course.getDuration());
        courseResponseDTO.setPrice(course.getPrice());
        courseResponseDTO.setCreatedOn(course.getCreatedOn());
        courseResponseDTO.setLastModified(course.getLastModified());

        return courseResponseDTO;
    }

}
