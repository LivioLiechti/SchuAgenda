package com.example.demo.repository;

import com.example.demo.model.Eintrag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EintragRepository extends JpaRepository<Eintrag, Integer> {
}
