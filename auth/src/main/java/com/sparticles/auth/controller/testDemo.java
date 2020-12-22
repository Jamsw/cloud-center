package com.sparticles.auth.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/cc")
@Slf4j
public class testDemo {
    @Autowired
    private RestTemplate restTemplate;
    @PostMapping("ceshi")
    public Integer test(HttpServletRequest request){
        log.info("auth");
        restTemplate.getForObject("http://client/ccc/ceshi",String.class);
        return 1;
    }
}
