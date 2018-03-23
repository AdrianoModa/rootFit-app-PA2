package com.rootfit.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rootfit.model.Aluno;
import com.rootfit.services.AlunoService;

@RestController
@RequestMapping("/aluno")
@CrossOrigin("${origem-permitida}")
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;
	
	@GetMapping
	public List<Aluno> listarTodos(){
		return alunoService.ListarTodosAlunos();
	}
	
	@GetMapping("/{id}")
	public Aluno listarPorId(@PathVariable @Valid Long id){
		return alunoService.buscarPorId(id);
	}
	
	@PostMapping("/aluno")
	public Aluno cadastrarLogin(@RequestBody Aluno aluno){
		return alunoService.adicionarAluno(aluno);
	}
	
	@PutMapping("/{id}/{nomeAluno}/{peso}/{altura}/{matricula}")
	public Aluno adicionar(
			@PathVariable Long id,
			@PathVariable String nomeAluno,
			@PathVariable float peso,
			@PathVariable float altura,
			@PathVariable String matricula){
		Aluno aluno = alunoService.buscarPorId(id);
		aluno.setNomeAluno(nomeAluno);
		aluno.setPeso(peso);
		aluno.setAltura(altura);
		aluno.setMatricula(matricula);		
		return alunoService.adicionarAluno(aluno);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id){
		Aluno aluno = alunoService.buscarPorId(id);
		if (aluno == null) {
			ResponseEntity.notFound().build();
		}
		alunoService.removerAluno(aluno.getId());
		return ResponseEntity.noContent().build();
	}

}
