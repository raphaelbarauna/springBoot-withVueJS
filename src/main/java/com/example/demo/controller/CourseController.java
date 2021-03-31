package com.example.demo.controller;

import com.example.demo.dto.CourseDTO;
import com.example.demo.model.Aluno;
import com.example.demo.model.Course;
import com.example.demo.repositories.AlunoRepository;
import com.example.demo.repositories.CourseRepository;
import com.example.demo.services.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseManagementService;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    AlunoRepository alunoRepository;


    @GetMapping("/all")
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseManagementService.findAll();

        Aluno aluno = alunoRepository.getOne(1);

        log.info("Coursos listados por username e description:" + aluno.toString());

        alunoRepository.delete(aluno);
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        Course courses = courseManagementService.findById(id).get();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @PostMapping(path = "/save")
    public ResponseEntity<Course> saveCourse(@RequestBody CourseDTO course) {

        Course course1 = new Course(course.getId(), course.getUsername(), course.getDescription(), course.getFilePath());

        Course createdCourse = courseRepository.save(course1);

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
