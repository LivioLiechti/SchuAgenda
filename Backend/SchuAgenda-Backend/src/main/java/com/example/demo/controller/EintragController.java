package com.example.demo.controller;

import com.example.demo.model.Eintrag;
import com.example.demo.model.Eintrag_Tag;
import com.example.demo.repository.Eintrag_TagRepository;
import com.example.demo.services.EintragService.EintragService;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value="/eintrag")
public class EintragController {
    private final EintragService eintragService;
    private final Eintrag_TagRepository eintragTagRepository;

    public EintragController(EintragService eintragService, Eintrag_TagRepository eintrag_tagRepository) {
        this.eintragService = eintragService;
        this.eintragTagRepository = eintrag_tagRepository;
    }

    @PostMapping
    public ResponseEntity<Eintrag> createEintrag(@Validated @RequestBody Eintrag eintrag) {
        if(eintragService.findById(eintrag.getEintragID()) != null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }else{
            Eintrag createdEintrag = eintragService.save(eintrag);
            if (createdEintrag == null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(createdEintrag, HttpStatus.CREATED);
        }
    }

    @GetMapping
    public ResponseEntity<List<Eintrag>> getAllEigenschaften() {
        List<Eintrag> eintrag = eintragService.findAll();
        return new ResponseEntity<>(eintrag, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Eintrag> getEintragByID(@PathVariable Integer id) {
        Eintrag eintrag = eintragService.findById(id);
        if (eintrag == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(eintrag, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEintrag(@PathVariable Integer id) throws DataAccessException {
        Eintrag eintrag = eintragService.findById(id);
        List<Eintrag_Tag> eintragTagList = eintrag.getEintragTag();
        if (eintrag == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        for (Eintrag_Tag eintrag_tag : eintragTagList) {
            if (eintrag.getEintragID() == eintrag_tag.getEintrag().getEintragID()) {
                eintrag_tag.setEintrag(eintrag_tag.getEintrag());
                eintrag_tag.setTag(eintrag_tag.getTag());
                eintragTagRepository.delete(eintrag_tag);
            }
        }
        eintragService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Eintrag> updateEintrag(@RequestBody Eintrag eintrag, @PathVariable Integer id) {
        if(eintragService.findById(id) == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            eintragService.save(eintrag);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
