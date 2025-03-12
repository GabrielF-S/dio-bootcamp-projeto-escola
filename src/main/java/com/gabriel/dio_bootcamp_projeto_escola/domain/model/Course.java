package com.gabriel.dio_bootcamp_projeto_escola.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String courseName;
    @OneToMany()
    private List<Discipline> disiplines;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Student> studants;
    private int periode;


    @PrePersist
    public void prePersist(){
        setPeriode(LocalDate.now().getYear());
    }

    public void addStudent(Student student) {
        this.studants.add(student);
    }
}
