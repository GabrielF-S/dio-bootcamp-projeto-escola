package com.gabriel.dio_bootcamp_projeto_escola.domain.entity;

import com.gabriel.dio_bootcamp_projeto_escola.domain.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
