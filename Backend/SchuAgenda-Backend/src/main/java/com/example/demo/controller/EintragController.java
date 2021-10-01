package com.example.demo.controller;

import com.example.demo.model.Example;
import com.example.demo.services.exampleService.ExampleService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/Eintrag")
public class EintragController {
    private final EintragService EintragService;

    public EintragController(EintragService EintragService){
        this.EintragService = EintragService;
    }

    @PostMapping("/")
    public void createEintrag(@Validated @RequestBody Eintrag eintrag){
        EintragService.save(Eintrag);
    }
}
