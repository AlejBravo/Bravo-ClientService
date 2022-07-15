package com.example.patagoniatest.feignclient;

import com.example.patagoniatest.entity.Subject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "subjectservice")
@RequestMapping("/subject")
public interface SubjectFeignClient {

    @PostMapping()
    Subject saveSubject(@RequestBody Subject subject);

    @GetMapping("/bystudent/{userId}")
    List<Subject> getSubjects(@PathVariable("studentId") int studentId);
}
