package com.example.patagoniatest.service;

import com.example.patagoniatest.config.RestTemplate;
import com.example.patagoniatest.entity.Subject;
import com.example.patagoniatest.feignclient.SubjectFeignClient;
import com.example.patagoniatest.model.Student;
import com.example.patagoniatest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    SubjectFeignClient subjectFeignClient;

    @Autowired
    RestTemplate restTemplate;

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Student getStudent(Long id) {
        return studentRepository.findById((id);
    }

    public Subject saveSubject(Long studentId, Subject subject){
        subject.setId(studentId);
        Subject newSubject = subjectFeignClient.saveSubject(subject);
        return newSubject;
    }
    public List<Subject> getSubject(Long studentId) {
        List<Subject> subjects = restTemplate.("http://subject-service/subject/byuser/" + studentId, List.class);
        return (List<Subject>) subjectFeignClient.;
    }
}
