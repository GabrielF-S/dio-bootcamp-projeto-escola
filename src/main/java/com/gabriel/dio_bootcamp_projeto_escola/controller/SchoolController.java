package com.gabriel.dio_bootcamp_projeto_escola.controller;

import com.gabriel.dio_bootcamp_projeto_escola.domain.dto.DtoCourseStudent;
import com.gabriel.dio_bootcamp_projeto_escola.domain.dto.DtoScores;
import com.gabriel.dio_bootcamp_projeto_escola.domain.model.Course;
import com.gabriel.dio_bootcamp_projeto_escola.domain.model.School;
import com.gabriel.dio_bootcamp_projeto_escola.domain.model.Student;
import com.gabriel.dio_bootcamp_projeto_escola.service.SchoolService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Locale;
@OpenAPIDefinition(servers = {@Server(url = "/", description = "Default server URL")})
@RestController
@RequestMapping(value = "/school")
public class SchoolController {

    @Autowired
    SchoolService service;

    @PutMapping("/{schoolName}/sendScore")
    public ResponseEntity<Student> throwsStudentScore(@PathVariable String schoolName, @RequestBody DtoScores dtoScores){
        if (schoolName.contains("-")){
            schoolName.replaceAll("-", " ");
        }
        Student student =service.insertScoreToStudent(schoolName, dtoScores);
        return ResponseEntity.ok().body(student);
    }

    @PutMapping("/insertAtCourse/{schoolId}/{courseId}")
    public ResponseEntity<School> insertStudentAtCourseById(@PathVariable Long schoolId,  @PathVariable Long courseId, @RequestBody Student student){
        School schoolUpdated = service.insertStudentInSchoolById(schoolId, courseId, student);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{nameStudent}")
                .buildAndExpand(student.getStudentName()).toUri();
        return ResponseEntity.created(uri).body(schoolUpdated);
    }

    @PutMapping("/{schoolId}/insertCourse/")
    public ResponseEntity<School> insertCourseAtSchoolById(@PathVariable Long schoolId, @RequestBody Course course){
        School schoolUpdated = service.insertCourseInSchooByIdl(schoolId, course);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{courseName}")
                .buildAndExpand(course.getCourseName()).toUri();
        return ResponseEntity.created(uri).body(schoolUpdated);
    }

    @GetMapping(value = "/{schoolId}")
    public ResponseEntity<School> getSchoolById(@PathVariable Long schoolId){
        School schoolSearch = service.findyById(schoolId);
        return ResponseEntity.ok().body(schoolSearch);
    }


    @PutMapping("/{schoolName}/inserStudentAtCourse")
    public ResponseEntity<School> insertStudentAtCourse(@PathVariable String schoolName, @RequestBody DtoCourseStudent dtoCourseStudent){
        if (schoolName.contains("-")){
            schoolName.replaceAll("-", " ");
        }
        School schoolUpdated = service.insertStudentInSchool(schoolName, dtoCourseStudent.getCourseName(), dtoCourseStudent.getStudent());
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{nameStudent}")
                .buildAndExpand(dtoCourseStudent.getStudent().getStudentName()).toUri();
        return ResponseEntity.created(uri).body(schoolUpdated);
    }

    @PutMapping("name/{schoolName}/insertCourse")
    public ResponseEntity<School> insertCourseAtSchool(@PathVariable String schoolName, @RequestBody Course course){
        if (schoolName.contains("-")){
            schoolName.replaceAll("-", " ");
        }
        course.setCourseName(course.getCourseName().toLowerCase());
        School schoolUpdated = service.insertCourseInSchool(schoolName, course);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{courseName}")
                .buildAndExpand(course.getCourseName()).toUri();
        return ResponseEntity.created(uri).body(schoolUpdated);
    }

    @GetMapping(value = "/name/{schoolName}")
    public ResponseEntity<School> getSchoolByName(@PathVariable String schoolName){
        if (schoolName.contains("-")){
           schoolName = schoolName.replaceAll("-", " ");
        }
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
