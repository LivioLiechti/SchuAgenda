package com.example.demo.services.exampleService;

import com.example.demo.model.Example;
import com.example.demo.repository.ExampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExampleServiceImpl implements ExampleService{
    private final ExampleRepository exampleRepository;

    @Autowired
    public ExampleServiceImpl(ExampleRepository exampleRepository) {
        this.exampleRepository = exampleRepository;
    }

    @Override
    public Example save(Example object) {
        return exampleRepository.saveAndFlush(object);
    }

    @Override
    public List<Example> findAll() {
        return exampleRepository.findAll();
    }

    @Override
    public Optional<Example> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void delete(Example example) {

    }

    @Override
    public void deleteById(String s) {
    }

    @Override
    public Example findById(String s) {
        return null;
    }
}
