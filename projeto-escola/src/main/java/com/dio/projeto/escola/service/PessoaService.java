package com.dio.projeto.escola.service;

import com.dio.projeto.escola.model.Pessoas;
import com.dio.projeto.escola.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoas savePessoa(Pessoas pessoas){
        return pessoaRepository.save(pessoas);
    }
}
