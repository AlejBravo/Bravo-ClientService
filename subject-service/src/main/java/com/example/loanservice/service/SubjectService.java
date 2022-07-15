package com.example.loanservice.service;


import com.example.loanservice.entity.Subject;
import com.example.loanservice.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    SubjectRepository subjectRepository;

    public Subject saveSubject(Subject loan){
        Subject newSubject = subjectRepository.save(loan);
        return newSubject;
    }

    public List<Subject> getAll(){
        return subjectRepository.findAll();
    }
}
