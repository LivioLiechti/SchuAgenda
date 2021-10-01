package com.example.demo.controller;

import com.example.demo.model.Eintrag;
import com.example.demo.model.Eintrag_Tag;
import com.example.demo.model.Eintrag_Tag_Pk;
import com.example.demo.model.Tag;
import com.example.demo.repository.Eintrag_TagRepository;
import com.example.demo.services.EintragService.EintragService;
import com.example.demo.services.TagService.TagService;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value="/eintragtag")
public class Eintrag_Tag_Controller {
    private final EintragService eintragService;
    private final TagService tagService;
    private final Eintrag_TagRepository eintragTagRepository;

    public Eintrag_Tag_Controller(EintragService eintragService, TagService tagService, Eintrag_TagRepository eintrag_tagRepository) {
        this.eintragService = eintragService;
        this.tagService = tagService;
        this.eintragTagRepository = eintrag_tagRepository;
    }

    @PostMapping("/{eintragId}/{tagId}")
    public ResponseEntity<Eintrag_Tag> addEintragToTag(@PathVariable Integer eintragId, @PathVariable Integer tagId) {
        Eintrag_Tag_Pk eintragTagPk = new Eintrag_Tag_Pk();
        eintragTagPk.setEintrag(eintragId);
        eintragTagPk.setTag(tagId);
        if(eintragTagRepository.findById(eintragTagPk).isPresent()){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }else{
            Eintrag_Tag eintrag_Tag = this.eintragTagRepository.save(formeEintragTag(eintragId, tagId));
            if (eintrag_Tag == null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(eintrag_Tag, HttpStatus.CREATED);
        }
    }

    @GetMapping
    public ResponseEntity<List<Eintrag_Tag>> getAllEintrag_Tag() {
        List<Eintrag_Tag> eintragTagList = eintragTagRepository.findAll();
        return new ResponseEntity<>(eintragTagList, HttpStatus.OK);
    }

    @GetMapping("/{eintragId}/{tagId}")
    public ResponseEntity<Eintrag_Tag> getEintrag_TagById(@PathVariable Integer eintragId,
                                                                          @PathVariable Integer tagId) {
        Eintrag_Tag eintrag_tag = formeEintragTag(eintragId, tagId);
        if (eintrag_tag.getEintrag() == null ||
                eintrag_tag.getTag() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(eintrag_tag, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/{eintragId}/{tagId}")
    public void deleteEintrag_Tag(@PathVariable Integer eintragId, @PathVariable Integer tagId) throws DataAccessException {
        this.eintragTagRepository.delete(formeEintragTag(eintragId, tagId));
    }

    private Eintrag_Tag formeEintragTag(Integer eintragId, Integer tagId) {
        Eintrag eintrag = this.eintragService.findById(eintragId);
        Tag tag = this.tagService.findById(tagId);
        Eintrag_Tag eintrag_tag = new Eintrag_Tag();
        eintrag_tag.setEintrag(eintrag);
        eintrag_tag.setTag(tag);
        return eintrag_tag;
    }
}
