package com.gabriel.dio_bootcamp_projeto_escola.domain.entity;

import com.gabriel.dio_bootcamp_projeto_escola.domain.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
