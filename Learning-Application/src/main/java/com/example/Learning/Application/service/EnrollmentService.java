package com.example.Learning.Application.service;

import com.example.Learning.Application.entity.Course;
import com.example.Learning.Application.entity.Enrollment;

import java.util.List;

public interface EnrollmentService {

    Enrollment enrollStudent(Long studentId, Long courseId);
    List<Course> getEnrolledCourses(Long studentId);
}
