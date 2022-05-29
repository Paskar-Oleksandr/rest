package com.rest.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test/string/controller")
    //@ResponseStatus(HttpStatus.CONFLICT)
    public String getTestString() {
        return "Just a test string from controller";
    }

}
