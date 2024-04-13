package com.dio.projeto.escola.service;

import com.dio.projeto.escola.model.Aluno;
import com.dio.projeto.escola.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public void saveAluno(Aluno aluno) {
        alunoRepository.save(aluno);
    }

    public List<Aluno> consultarTodosAlunos(){
        return alunoRepository.findAll();
    }

    public List<Aluno> consultarAlunoPorNome(String nome){
       return alunoRepository.findByNomeContainingIgnoreCase(nome);
    }
}
