package com.dio.projeto.escola.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tab_matricularaluno")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class MatricularAluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMatriculaAluno;

    @ManyToOne
    @JoinColumn(name = "idTurma")
    private Turma idTurma;

    @ManyToOne
    @JoinColumn(name = "nome")
    private Pessoas nome;

    @ManyToOne
    @JoinColumn(name = "nomeCurso")
    private Cursos nomeCurso;

    @Column(name = "Horario do Curso", nullable = false)
    private String horarioCurso;
}
