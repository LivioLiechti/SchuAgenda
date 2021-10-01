package com.example.demo.services.EintragService;

import com.example.demo.model.Eintrag;
import com.example.demo.services.CrudService;

import java.util.List;

public interface EintragService extends CrudService<Eintrag, Integer> {
    Eintrag save(Eintrag object);
    List<Eintrag> findAll();
    void deleteById(Integer id);
    Eintrag findById(Integer id);
    void delete(Eintrag object);
}
