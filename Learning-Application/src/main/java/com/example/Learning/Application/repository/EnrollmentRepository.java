package com.example.Learning.Application.repository;

import com.example.Learning.Application.entity.Enrollment;
import com.example.Learning.Application.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    List<Enrollment> findByStudent(User student);
}
