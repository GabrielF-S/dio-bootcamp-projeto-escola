package com.gabriel.dio_bootcamp_projeto_escola.domain.entity;

import com.gabriel.dio_bootcamp_projeto_escola.domain.model.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface SchoolRepository extends JpaRepository<School, Long> {

    Optional<School> findBySchoolName(String schoolName);

    boolean existsBySchoolName(String schoolName);
}
