package com.br.antonio.testapi.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.antonio.testapi.error.ResourceNotFoundException;
import com.br.antonio.testapi.model.Aluno;
import com.br.antonio.testapi.service.AlunoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
	
	@Autowired
	AlunoService alunoService;
	
	@ApiOperation(value = "Retorna a lista de alunos")
	@GetMapping
	public ResponseEntity<List<Aluno>> findAll(){
		return new ResponseEntity<>(alunoService.findAll(),HttpStatus.OK);
	}
	
	@ApiOperation(value = "Retorna aluno pelo id")
	@GetMapping("{id}")
	public ResponseEntity<Optional<Aluno>> findById(@PathVariable("id") Long id) {
		verifyIfAlunoExists(id);
		return new ResponseEntity<>(alunoService.findById(id),HttpStatus.OK);
	}
	
	@ApiOperation(value = "Cria um aluno")
	@PostMapping
	public ResponseEntity<?> createAluno(@Valid @RequestBody Aluno aluno) {
		return new ResponseEntity<>(alunoService.createOrUpdate(aluno),HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Atualiza os dados de um aluno")
	@PutMapping
	public ResponseEntity<?> updateAluno(@Valid @RequestBody Aluno aluno) {
		
		verifyIfAlunoExists(aluno.getId());
		
		return new ResponseEntity<>(alunoService.createOrUpdate(aluno),HttpStatus.OK);
		
	}
	
	@ApiOperation(value = "Deleta um aluno")
	@DeleteMapping()
	public ResponseEntity<?> deleteAluno(@RequestBody Aluno aluno){
		
		verifyIfAlunoExists(aluno.getId());
		alunoService.delete(aluno.getId());
		return ResponseEntity.noContent().build();		
	}
	
	private void verifyIfAlunoExists(Long id) {
		if(!alunoService.findById(id).isPresent()) {
			throw new ResourceNotFoundException("Aluno não encontrado id: "+id);
		}
	}

}
