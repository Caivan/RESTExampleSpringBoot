package com.devbeerloper.apirestexample.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/saludar")
public class HelloWorldController {

    @GetMapping("/hello")
    public String sayHi () {
        return "Hello World";
    }
}
