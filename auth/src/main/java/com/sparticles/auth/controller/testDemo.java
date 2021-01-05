package com.sparticles.auth.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/cc")
@Slf4j
public class testDemo {
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("ceshi")
    public Integer test(@RequestParam("code")String code){
        log.info(code);
        //uD2D3F
        //restTemplate.getForObject("http://client/ccc/ceshi",String.class);
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(new org.apache.tomcat.util.codec.binary.Base64().encodeAsString("test_client:test_secret".getBytes()));
        System.out.println(java.util.Base64.getEncoder().encodeToString("test_client:test_secret".getBytes()));
    }
}
