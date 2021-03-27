package com.example.demo.controller;

import com.example.demo.model.Course;
import com.example.demo.repositories.CourseRepository;
import com.example.demo.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseManagementService;

    @Autowired
    CourseRepository courseRepository;


    @GetMapping("/all")
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseManagementService.findAll();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        Course courses = courseManagementService.findById(id).get();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @PostMapping(path = "/save", consumes = {"multipart/form-data"})
    public ResponseEntity<Course> saveCourse(@RequestBody Course course) {
        System.out.println(course.getFile().getOriginalFilename());
        Course createdCourse = courseRepository.save(course);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdCourse.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }


    @PostMapping("/update")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course) {
        Course courseUpdated = courseRepository.save(course);

        return new ResponseEntity<>(courseUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {

        if(courseManagementService.findById(id).isPresent()){
            courseManagementService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
