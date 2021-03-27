package com.example.demo.services;

import com.example.demo.model.Course;
import com.example.demo.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    private static final List<Course> courses = new ArrayList<>();
    private static long idCounter = 0;


    public List<Course> findAllByUserName(String userName) {
        List<Course> coursesList = courseRepository.findByUsername(userName);
        return coursesList;
    }

    @Transactional
    public void deleteById(Long id){

    courseRepository.deleteCourseById(id);

    }

    public List<Course> findAll(){

        return courseRepository.findAll();

    }

    public Optional<Course> findById(Long id){
        return courseRepository.findCourseById(id);
    }
}
