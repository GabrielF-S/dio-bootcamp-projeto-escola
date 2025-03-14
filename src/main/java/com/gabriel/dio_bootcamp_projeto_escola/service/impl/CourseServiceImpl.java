package com.gabriel.dio_bootcamp_projeto_escola.service.impl;

import com.gabriel.dio_bootcamp_projeto_escola.domain.entity.CourseRepository;
import com.gabriel.dio_bootcamp_projeto_escola.domain.model.Course;
import com.gabriel.dio_bootcamp_projeto_escola.domain.model.Discipline;
import com.gabriel.dio_bootcamp_projeto_escola.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Currency;
import java.util.NoSuchElementException;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseRepository repository;
    @Override
    public Course getById(Long id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Course getByName(String courseName) {
        if (repository.existsByCourseName(courseName)){
            return repository.findByCourseName(courseName);
        }else {
            throw   new NoSuchElementException();
        }
    }

    @Override
    public Course insertDiscipline(String courseName, Discipline discipline) {
        if (repository.existsByCourseName(courseName)){
            Course course = repository.findByCourseName(courseName);
            course.addDiscipline(discipline);
            return  repository.save(course);
        }else {
            throw   new NoSuchElementException();
        }
    }
}
