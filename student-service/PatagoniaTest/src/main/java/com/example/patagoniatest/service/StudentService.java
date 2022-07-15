package com.example.patagoniatest.service;

import com.example.patagoniatest.entity.Subject;
import com.example.patagoniatest.feignclient.SubjectFeignClient;
import com.example.patagoniatest.model.Student;
import com.example.patagoniatest.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    SubjectFeignClient subjectFeignClient;

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Optional<Student> getStudent(Long id) {
        return studentRepository.findById(id);
    }

    public Subject saveSubject(Long studentId, Subject subject){
        subject.setId(studentId);
        Subject newSubject = subjectFeignClient.saveSubject(subject);
        return newSubject;
    }
}
