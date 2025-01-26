package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

    String greeting = "Hello User!";

    @GetMapping("/greet")
    public String greetUser()
    {
     return greeting;
    }
}
