package com.example.demo.controller;

import com.example.demo.model.Example;
import com.example.demo.services.exampleService.ExampleService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/tag")
public class tagController {
    private final ExampleService exampleService;

    public tagController(ExampleService exampleService){
        this.exampleService = exampleService;
    }

    @PostMapping("/")
    public void createBeruf(@Validated @RequestBody Example example){
        exampleService.save(example);
    }
}
