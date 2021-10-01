package com.example.demo.services.TagService;

import com.example.demo.model.Tag;
import com.example.demo.repository.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    private final TagRepository tagRepository;

    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public Tag save(Tag object) {
        return tagRepository.save(object);
    }

    @Override
    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        tagRepository.deleteById(id);
    }

    @Override
    public Tag findById(Integer id) {
        return tagRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Tag object) {
        tagRepository.delete(object);
    }
}
