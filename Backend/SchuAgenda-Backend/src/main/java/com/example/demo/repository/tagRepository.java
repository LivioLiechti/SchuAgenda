package com.example.demo.repository;

import com.example.demo.model.Example;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<tag, Integer> {
}