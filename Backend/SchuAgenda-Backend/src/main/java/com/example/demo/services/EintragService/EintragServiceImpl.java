package com.example.demo.services.EintragService;

import com.example.demo.model.Eintrag;
import com.example.demo.repository.EintragRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EintragServiceImpl implements EintragService{
    private final EintragRepository eintragRepository;

    @Autowired
    public EintragServiceImpl(EintragRepository eintragRepository) {
        this.eintragRepository = eintragRepository;
    }

    @Override
    public Eintrag save(Eintrag object) {
        return eintragRepository.save(object);
    }

    @Override
    public List<Eintrag> findAll() {
        return eintragRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        eintragRepository.deleteById(id);
    }

    @Override
    public Eintrag findById(Integer id) {
        return eintragRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Eintrag eintrag) {
        eintragRepository.delete(eintrag);
    }
}
