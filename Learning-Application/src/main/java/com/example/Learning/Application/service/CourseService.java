package com.example.Learning.Application.service;

import com.example.Learning.Application.dto.CourseDto;
import com.example.Learning.Application.entity.Course;

import java.util.List;

public interface CourseService {

    Course createCourse(CourseDto dto);
    List<Course> getAllCourses();
}
