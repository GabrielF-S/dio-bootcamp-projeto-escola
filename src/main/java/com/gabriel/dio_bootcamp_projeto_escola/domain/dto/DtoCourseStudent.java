package com.gabriel.dio_bootcamp_projeto_escola.domain.dto;

import com.gabriel.dio_bootcamp_projeto_escola.domain.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoCourseStudent {
    private String courseName;
    private Student student;

}
