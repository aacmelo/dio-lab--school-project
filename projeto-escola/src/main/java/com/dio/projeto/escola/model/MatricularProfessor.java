package com.dio.projeto.escola.model;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "tab_matricularprofessor")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MatricularProfessor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMatriculaProfessor;

    @ManyToOne
    @JoinColumn(name = "id_turma_id_turma")
    private Turma idTurma;

    @ManyToOne
    @JoinColumn(name = "nome_professor_id_pessoa")
    private Aluno nomeProfessor;

    @ManyToOne
    @JoinColumn(name = "materia_curso_id_curso")
    private Cursos materiasCurso;

    @Column(name = "Dia da Semana", nullable = false)
    private String diaSemana;

    @Column(name = "Horario da Turma", nullable = false)
    private String horarioTurma;
}
