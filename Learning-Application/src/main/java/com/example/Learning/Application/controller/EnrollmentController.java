package com.example.Learning.Application.controller;

import com.example.Learning.Application.entity.Course;
import com.example.Learning.Application.entity.Enrollment;
import com.example.Learning.Application.service.EnrollmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;
    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @PostMapping("/enroll")
    public Enrollment enrollStudent(@RequestParam Long studentId, @RequestParam Long courseId) {
        return enrollmentService.enrollStudent(studentId, courseId);
    }

    @GetMapping("/student/{studentId}")
    public List<Course> getEnrolledCourses(@PathVariable Long studentId) {
        return enrollmentService.getEnrolledCourses(studentId);
    }
}
