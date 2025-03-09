package com.gabriel.dio_bootcamp_projeto_escola.controller;

import com.gabriel.dio_bootcamp_projeto_escola.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    SchoolService service;




}
