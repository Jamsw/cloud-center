package com.sparticles.client.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/ccc")
@Slf4j
public class testDemo {

    @GetMapping("ceshi")
    public Integer test(HttpServletRequest request){
        log.info("clin1111");
        return 2;
    }
}
