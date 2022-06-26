package com.example.patagoniatest.feignclient;

import com.example.patagoniatest.entity.Loan;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "loanservice")
@RequestMapping("/loan")
public interface LoanFeignClient {

    @PostMapping()
    Loan saveLoan(@RequestBody Loan loan);
}
