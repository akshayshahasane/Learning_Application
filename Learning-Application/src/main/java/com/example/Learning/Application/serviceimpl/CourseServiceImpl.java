package com.example.Learning.Application.serviceimpl;

import com.example.Learning.Application.dto.CourseDto;
import com.example.Learning.Application.entity.Course;
import com.example.Learning.Application.entity.User;
import com.example.Learning.Application.exception.ResourceNotFoundException;
import com.example.Learning.Application.repository.CourseRepository;
import com.example.Learning.Application.repository.UserRepository;
import com.example.Learning.Application.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {


    private final CourseRepository courseRepo;

    private final UserRepository userRepo;

    public CourseServiceImpl(CourseRepository courseRepo, UserRepository userRepo) {
        this.courseRepo = courseRepo;
        this.userRepo = userRepo;
    }

    @Override
    public Course createCourse(CourseDto dto) {
        User instructor = userRepo.findById(dto.getInstructorId())
                .orElseThrow(() -> new ResourceNotFoundException("Instructor not found"));

        if (!"INSTRUCTOR".equalsIgnoreCase(instructor.getRole())) {
            throw new IllegalArgumentException("User is not an instructor");
        }

        Course course = Course.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .category(dto.getCategory())
                .price(dto.getPrice())
                .instructor(instructor)
                .build();

        return courseRepo.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }
}
