package com.dio.projeto.escola.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.dio.projeto.escola.model.Pessoas;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoas, Long> {
}
