package com.dio.projeto.escola.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "tab_cursos")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cursos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCurso;

    @Column(name = "Nome do Curso", length = 50, nullable = false)
    private String nomeCurso;

    @Column(name = "Matérias do Curso")
    private List<String> materiasCurso = new ArrayList<>();
}
