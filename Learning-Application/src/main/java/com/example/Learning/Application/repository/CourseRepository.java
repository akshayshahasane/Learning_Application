package com.example.Learning.Application.repository;

import com.example.Learning.Application.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
