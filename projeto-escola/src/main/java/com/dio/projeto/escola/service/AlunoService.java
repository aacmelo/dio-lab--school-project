package com.dio.projeto.escola.service;

import com.dio.projeto.escola.exception.AlunoNotFoundException;
import com.dio.projeto.escola.model.Aluno;
import com.dio.projeto.escola.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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

    public Aluno buscarAlunoPorId(Long id) throws AlunoNotFoundException{
        Optional<Aluno> opt = alunoRepository.findById(id);
        if(opt.isPresent()){
            return opt.get();
        }else{
            throw new AlunoNotFoundException("Aluno Não Cadastrado");
        }
    }

    public void apagarAluno(Long id) throws AlunoNotFoundException{
        Aluno aluno = buscarAlunoPorId(id);
        alunoRepository.delete(aluno);
    }

    public void editarAluno(Aluno aluno){
        alunoRepository.save(aluno);
    }
}