package com.example.demo.controller;

import com.example.demo.model.Eintrag;
import com.example.demo.model.Eintrag_Tag;
import com.example.demo.model.Tag;
import com.example.demo.repository.Eintrag_TagRepository;

import com.example.demo.services.TagService.TagService;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value="/tag")
public class TagController {
    private final TagService tagService;
    private final Eintrag_TagRepository eintragTagRepository;

    public TagController(TagService tagService, Eintrag_TagRepository eintragTagRepository) {
        this.tagService = tagService;
        this.eintragTagRepository = eintragTagRepository;
    }

    @PostMapping
    public ResponseEntity<Tag> createTag(@Validated @RequestBody Tag tag) {
        if(tagService.findById(tag.getTagid()) != null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }else{
            Tag createdTag = tagService.save(tag);
            if (createdTag == null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(createdTag, HttpStatus.CREATED);
        }
    }

    @GetMapping
    public ResponseEntity<List<Tag>> getAllTage() {
        List<Tag> tag = tagService.findAll();
        return new ResponseEntity<>(tag, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tag> getTagByID(@PathVariable Integer id) {
        Tag tag = tagService.findById(id);
        if (tag == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tag, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTag(@PathVariable Integer id) throws DataAccessException {
        Tag tag = tagService.findById(id);
        List<Eintrag_Tag> eintragTagList = tag.getEintragTag();
        if (tag == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        for (Eintrag_Tag eintrag_tag : eintragTagList) {
            if (tag.getTagid() == eintrag_tag.getTag().getTagid()) {
                eintrag_tag.setEintrag(eintrag_tag.getEintrag());
                eintrag_tag.setTag(eintrag_tag.getTag());
                eintragTagRepository.delete(eintrag_tag);
            }
        }
        tagService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Tag> updateTag(@RequestBody Tag tag, @PathVariable Integer id) {
        if(tagService.findById(id) == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            tagService.save(tag);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
