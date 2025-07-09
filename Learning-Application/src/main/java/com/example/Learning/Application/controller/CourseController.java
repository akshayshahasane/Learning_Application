package com.example.Learning.Application.controller;

import com.example.Learning.Application.dto.CourseDto;
import com.example.Learning.Application.entity.Course;
import com.example.Learning.Application.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {


    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public Course createCourse(@Valid @RequestBody CourseDto dto) {
        return courseService.createCourse(dto);
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }
}
