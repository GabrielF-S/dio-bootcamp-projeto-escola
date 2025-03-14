package com.gabriel.dio_bootcamp_projeto_escola.service;

import com.gabriel.dio_bootcamp_projeto_escola.domain.model.Course;
import com.gabriel.dio_bootcamp_projeto_escola.domain.model.Discipline;

public interface CourseService {
    Course getById(Long id);

    Course getByName(String name);

    Course insertDiscipline(String courseName, Discipline discipline);
}
