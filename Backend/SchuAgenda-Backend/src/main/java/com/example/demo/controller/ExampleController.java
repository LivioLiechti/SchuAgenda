package com.example.demo.controller;

import com.example.demo.model.Example;
import com.example.demo.services.exampleService.ExampleService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {
    private final ExampleService exampleService;

    public ExampleController(ExampleService exampleService){
        this.exampleService = exampleService;
    }


    @PostMapping
    public void createBeruf(@Validated @RequestBody Example example){
        exampleService.save(example);
    }
}
