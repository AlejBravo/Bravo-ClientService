package com.example.loanservice.controller;
import com.example.loanservice.entity.Subject;
import com.example.loanservice.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @GetMapping
    public List<Subject> getAll(){
        return subjectService.getAll();
    }

    @PostMapping()
    public ResponseEntity<Subject> saveSubject(@RequestBody Subject subject) {
        Subject newSubject = subjectService.saveSubject(subject);
        return ResponseEntity.ok(newSubject);
    }



}
