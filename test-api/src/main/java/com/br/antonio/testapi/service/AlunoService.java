package com.br.antonio.testapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.antonio.testapi.model.Aluno;
import com.br.antonio.testapi.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	AlunoRepository alunoRepository;
	
	public List<Aluno> findAll(){
		return alunoRepository.findAll();
	}
	
	public Optional<Aluno> findById(Long id) {
		return alunoRepository.findById(id);
		
	}
	
	public Aluno createOrUpdate(Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	public void delete(Long id) {
		alunoRepository.deleteById(id);
	}
	
}
