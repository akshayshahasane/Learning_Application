package com.example.Learning.Application.serviceimpl;

import com.example.Learning.Application.entity.Course;
import com.example.Learning.Application.entity.Enrollment;
import com.example.Learning.Application.entity.User;
import com.example.Learning.Application.exception.ResourceNotFoundException;
import com.example.Learning.Application.repository.CourseRepository;
import com.example.Learning.Application.repository.EnrollmentRepository;
import com.example.Learning.Application.repository.UserRepository;
import com.example.Learning.Application.service.EnrollmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository enrollmentRepo;
    private final UserRepository userRepo;
    private final CourseRepository courseRepo;

    public EnrollmentServiceImpl(EnrollmentRepository enrollmentRepo,
                                 UserRepository userRepo,
                                 CourseRepository courseRepo) {
        this.enrollmentRepo = enrollmentRepo;
        this.userRepo = userRepo;
        this.courseRepo = courseRepo;
    }

    @Override
    public Enrollment enrollStudent(Long studentId, Long courseId) {
        User student = userRepo.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        if (!"STUDENT".equalsIgnoreCase(student.getRole())) {
            throw new IllegalArgumentException("User is not a student");
        }

        Course course = courseRepo.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));

        Enrollment enrollment = Enrollment.builder()
                .student(student)
                .course(course)
                .build();

        return enrollmentRepo.save(enrollment);
    }

    @Override
    public List<Course> getEnrolledCourses(Long studentId) {
        User student = userRepo.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        return enrollmentRepo.findByStudent(student)
                .stream()
                .map(Enrollment::getCourse)
                .collect(Collectors.toList());
    }

}
