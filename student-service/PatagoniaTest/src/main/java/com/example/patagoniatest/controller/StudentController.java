package com.example.patagoniatest.controller;

import com.example.patagoniatest.entity.Subject;
import com.example.patagoniatest.model.Student;
import com.example.patagoniatest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;


@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public Optional<Student> getStudent(@PathVariable Long id){
        return studentService.getStudent(id);
    }
    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }

    @PostMapping("/saveSubject/{studentId}")
    public ResponseEntity<Subject> saveSubject(@PathVariable("studentId") Long studentId, @RequestBody Subject subject) {
        Subject newSubject = studentService.saveSubject(studentId, subject);
        return ResponseEntity.ok(subject);
    }

//    @GetMapping("/subjects")
//    public ResponseEntity<Subject> subjects(@PathVariable("studentId") Long studentId, @RequestBody Subject subject) {
//        Subject newLoan = studentService.saveSubject(studentId, subject);
//        return ResponseEntity.ok(subject);
//    }
}
