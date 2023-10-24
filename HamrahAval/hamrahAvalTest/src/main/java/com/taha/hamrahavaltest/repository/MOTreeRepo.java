package com.taha.hamrahavaltest.repository;

import com.taha.hamrahavaltest.entity.MOTreeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MOTreeRepo extends JpaRepository<MOTreeEntity, Long> {
}
