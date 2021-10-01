package com.example.demo.repository;

import com.example.demo.model.Eintrag_Tag;
import com.example.demo.model.Eintrag_Tag_Pk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Eintrag_TagRepository extends JpaRepository<Eintrag_Tag, Eintrag_Tag_Pk> {
}
