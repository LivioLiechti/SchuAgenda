package com.example.demo.services.TagService;

import com.example.demo.model.Tag;
import com.example.demo.services.CrudService;

import java.util.List;

public interface TagService extends CrudService<Tag, Integer> {
    Tag save(Tag object);
    List<Tag> findAll();
    void deleteById(Integer id);
    Tag findById(Integer id);
    void delete(Tag object);
}
