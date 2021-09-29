package com.example.demo.services.exampleService;

import com.example.demo.services.CrudService;
import com.example.demo.model.Example;

import java.util.List;
import java.util.Optional;

public interface ExampleService extends CrudService<Example, String> {
    Example save(Example object);
    List<Example> findAll();
    Optional<Example> findById(int id);
    void delete(Example example);
}
