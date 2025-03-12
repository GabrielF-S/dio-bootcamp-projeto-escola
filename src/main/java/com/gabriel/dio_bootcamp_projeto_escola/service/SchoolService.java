package com.gabriel.dio_bootcamp_projeto_escola.service;

import com.gabriel.dio_bootcamp_projeto_escola.domain.model.Course;
import com.gabriel.dio_bootcamp_projeto_escola.domain.model.School;
import com.gabriel.dio_bootcamp_projeto_escola.domain.model.Student;

public interface SchoolService {
    School findyBySchoolName(String nameSchool);

    School create(School school);

    School insertCourseInSchool(String schoolName, Course course);

    School insertStudentInSchool(String schoolName, String courseName, Student student);
}
