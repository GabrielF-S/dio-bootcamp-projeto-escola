package com.gabriel.dio_bootcamp_projeto_escola.controller;

import com.gabriel.dio_bootcamp_projeto_escola.domain.model.Course;
import com.gabriel.dio_bootcamp_projeto_escola.domain.model.School;
import com.gabriel.dio_bootcamp_projeto_escola.domain.model.Student;
import com.gabriel.dio_bootcamp_projeto_escola.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Locale;

@RestController
@RequestMapping(value = "/school")
public class SchoolController {

    @Autowired
    SchoolService service;



    @PutMapping("/insertCourse/{schoolName}/{courseName}")
    public ResponseEntity<School> insertCourse(@PathVariable String schoolName,  @PathVariable String courseName, @RequestBody Student student){
        School schoolUpdated = service.insertStudentInSchool(schoolName, courseName, student);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{nameStudent}")
                .buildAndExpand(student.getStudentName()).toUri();
        return ResponseEntity.created(uri).body(schoolUpdated);
    }

    @PutMapping("/insertCourse/{schoolName}")
    public ResponseEntity<School> insertCourse(@PathVariable String schoolName, @RequestBody Course course){
        School schoolUpdated = service.insertCourseInSchool(schoolName, course);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{courseName}")
                .buildAndExpand(course.getCourseName()).toUri();
        return ResponseEntity.created(uri).body(schoolUpdated);
    }

    @GetMapping(value = "/{schoolName}")
    public ResponseEntity<School> getSchoolByName(@PathVariable String schoolName){
        School schoolSearch = service.findyBySchoolName(schoolName.toLowerCase(Locale.ROOT));
        return ResponseEntity.ok().body(schoolSearch);
    }

    @PostMapping("/create")
    public ResponseEntity<School> createSchool(@RequestBody School school){
        School schoolCreated = service.create(school);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{schoolName}")
                .buildAndExpand(schoolCreated.getSchoolName()).toUri();

        return ResponseEntity.created(uri).body(schoolCreated);
    }


}
