package com.dio.projeto.escola.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tab_turma")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTurma;

    @ManyToOne
    @JoinColumn(name = "nomeCurso")
    private Cursos nomeCurso;

    @OneToMany
    private List<MatricularAluno> alunos = new ArrayList<>();
}
