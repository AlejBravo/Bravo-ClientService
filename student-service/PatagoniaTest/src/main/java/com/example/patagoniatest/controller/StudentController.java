package com.example.patagoniatest.controller;

import com.example.patagoniatest.entity.Subject;
import com.example.patagoniatest.model.Student;
import com.example.patagoniatest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAll(){
        return studentService.getStudents();
    }

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public void deleteStudent(@PathVariable Long studentId){
        studentService.deleteStudent(studentId);
    }

    @PostMapping("/saveSubject/{studentId}")
    public ResponseEntity<Subject> saveSubject(@PathVariable("studentId") Long studentId, @RequestBody Subject subject) {
        Subject newSubject = studentService.saveSubject(studentId, subject);
        return ResponseEntity.ok(subject);
    }

    //    @GetMapping("/{id}")
//    public Student getStudent(@PathVariable Long studentId){
//        return studentService.getStudent(studentId);
//    }

//    @GetMapping("/subjects/{studentId}")
//    public ResponseEntity<List<Subject>> getSubjectById(@PathVariable("studentId") Long studentId) {
//        Student student = studentService.getStudent(studentId);
//        List<Subject> subjects = studentService.getSubject(studentId);
//        return ResponseEntity.ok(subjects);
//    }

}
