package com.example.patagoniatest.repository;

import com.example.patagoniatest.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByFullName(String fullName);
}