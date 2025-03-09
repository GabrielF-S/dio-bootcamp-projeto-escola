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
@Table(name = "tb_studant")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private HashMap<String, Double> scores;

    public void setScores(String course, Double score) {
        this.scores.put(course, score);
    }
}
