package com.taha.hamrahavaltest.repository;

import com.taha.hamrahavaltest.entity.MOEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MORepo extends JpaRepository<MOEntity, Long> {
}
