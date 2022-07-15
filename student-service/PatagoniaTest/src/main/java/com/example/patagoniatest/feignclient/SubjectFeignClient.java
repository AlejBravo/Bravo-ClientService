package com.example.patagoniatest.feignclient;

import com.example.patagoniatest.entity.Subject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "subjectservice")
@RequestMapping("/subject")
public interface SubjectFeignClient {

    @PostMapping()
    Subject saveSubject(@RequestBody Subject subject);
}
