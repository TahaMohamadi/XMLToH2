package com.taha.hamrahavaltest.repository;

import com.taha.hamrahavaltest.entity.AttrEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttrRepo extends JpaRepository<AttrEntity, Long> {
}
