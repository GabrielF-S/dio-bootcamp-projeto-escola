package com.gabriel.dio_bootcamp_projeto_escola.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_aluno")
public class Studant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private HashMap<String, Double> scores;


    public void setNotas(String disciplina,  Double scores) {
        this.scores.put(disciplina, scores);

    }
}
