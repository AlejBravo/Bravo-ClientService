package com.example.patagoniatest.config;

import com.example.patagoniatest.entity.Subject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class RestTemplate {
    @Bean
    public RestTemplate restTemplate() {
       return new RestTemplate();
    }
}
