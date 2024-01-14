package com.zubi.spring.projects.service.discovery.api.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
@Slf4j
public class MyController {

    @GetMapping("/hello")
    public ResponseEntity getMyService(){
        log.info("inside hello controller endpoint.");
        return new ResponseEntity("My Service is working.. ", HttpStatus.OK);
    }
}
