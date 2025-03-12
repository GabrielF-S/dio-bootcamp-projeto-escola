package com.gabriel.dio_bootcamp_projeto_escola.service.impl;

import com.gabriel.dio_bootcamp_projeto_escola.domain.entity.SchoolRepository;
import com.gabriel.dio_bootcamp_projeto_escola.domain.model.Course;
import com.gabriel.dio_bootcamp_projeto_escola.domain.model.School;
import com.gabriel.dio_bootcamp_projeto_escola.domain.model.Student;
import com.gabriel.dio_bootcamp_projeto_escola.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    SchoolRepository repository;

    @Override
    public School findyBySchoolName(String schoolName) {
        return repository.findBySchoolName(schoolName).orElseThrow();
    }

    @Override
    public School create(School school) {
        if (repository.existsBySchoolName(school.getSchoolName())) {
            throw new NoSuchElementException("This school already exist");
        }
        school.setSchoolName(school.getSchoolName().toLowerCase(Locale.ROOT));
        return repository.save(school);
    }

    @Override
    public School insertCourseInSchool(String schoolName, Course course) {
        if (!repository.existsBySchoolName(schoolName.toLowerCase(Locale.ROOT))) {
            throw new NoSuchElementException();
        }
        School school = repository.findBySchoolName(schoolName).get();
        boolean courseExists = school.getCourses().stream().anyMatch(c -> c.getCourseName().equalsIgnoreCase(course.getCourseName()));
        if (!courseExists){
            course.setCourseName(course.getCourseName().toLowerCase());
            school.addCourse(course);
            return repository.save(school);
        }else {
            throw new IllegalArgumentException("Course alredy exists");
        }

    }

    @Override
    public School insertStudentInSchool(String schoolName, String courseName, Student student) {
        if (!repository.existsBySchoolName(schoolName.toLowerCase(Locale.ROOT))) {
            throw new NoSuchElementException();
        }

        School school = repository.findBySchoolName(schoolName).get();
        Optional<Student> studentToInsert;
        if (student.getId()!= null){
            studentToInsert = school.getCourses().stream()
                    .flatMap( course -> course.getStudants().stream())
                                    .filter(student1 -> student1.getId().equals(student.getId())).findAny();
        }else {
            studentToInsert = Optional.of(student);
        }
        school.getCourses().stream()
                .filter(c -> c.getCourseName().equalsIgnoreCase(courseName))
                .forEach(course -> course.addStudent(studentToInsert.get()));
        return repository.save(school);
    }


}
