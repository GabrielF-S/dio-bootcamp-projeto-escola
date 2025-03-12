package com.gabriel.dio_bootcamp_projeto_escola.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_discipline")
public class Discipline {

    private Long id;
    private String disciplineName;
    private int periode;
    private boolean current;
    private Double score;



}
