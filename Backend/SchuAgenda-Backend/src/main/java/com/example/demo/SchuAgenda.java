package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableScheduling
public class SchuAgenda {
    public static void main(String[] args) {
        SpringApplication.run(SchuAgenda.class, args);
    }
}
// Eintrag eintrag = new Eintrag();
//        Tag tag = new Tag();
//        System.out.println(eintrag.toString() + tag.toString());
