package com.gabriel.dio_bootcamp_projeto_escola.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@Table(name = "tb_student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String studentName;
    private String studentMail;
    private HashMap<String, Double> disciplineScore;

    public Student() {
        disciplineScore = new HashMap<>();
    }

    public void addScore(String discipline, Double score){
        disciplineScore.put(discipline, score);
    }
}
