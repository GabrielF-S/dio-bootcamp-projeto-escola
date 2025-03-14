package com.gabriel.dio_bootcamp_projeto_escola.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoScores {
    private Long studentId;
    private String courseName;
    private String disciplineName;
    private Double score;
}
