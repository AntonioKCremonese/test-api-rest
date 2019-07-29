package com.br.antonio.testapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.antonio.testapi.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
