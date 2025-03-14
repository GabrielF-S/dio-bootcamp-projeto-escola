package com.gabriel.dio_bootcamp_projeto_escola.controller;

import com.gabriel.dio_bootcamp_projeto_escola.domain.model.Course;
import com.gabriel.dio_bootcamp_projeto_escola.domain.model.Discipline;
import com.gabriel.dio_bootcamp_projeto_escola.service.CourseService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
@OpenAPIDefinition(servers = {@Server(url = "/", description = "Default server URL")})
@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseService service;

    @PostMapping("/{courseName}/insert")
    public ResponseEntity<Course> insertDiscipline(@PathVariable String courseName, @RequestBody Discipline discipline){
        if (courseName.contains("-")){
            courseName = courseName.replaceAll("-", " ");
        }
        Course courseUptaded = service.insertDiscipline(courseName,discipline);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{disciplineName}")
                .buildAndExpand(discipline.getDisciplineName()).toUri();
        return ResponseEntity.created(uri).body(courseUptaded);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.getById(id));
    }

    @GetMapping("/name/{courseName}")
    public ResponseEntity<Course> getCourseByName(@PathVariable String courseName){
        if (courseName.contains("-")){
            courseName = courseName.replaceAll("-", " ");
        }
        return ResponseEntity.ok().body(service.getByName(courseName.toLowerCase()));
    }
}
