package com.gabriel.dio_bootcamp_projeto_escola.domain.entity;

import com.gabriel.dio_bootcamp_projeto_escola.domain.model.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Long> {
}
