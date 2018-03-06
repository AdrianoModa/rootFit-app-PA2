package com.rootfit.resource;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rootfit.BO.AlunoBO;
import com.rootfit.model.Aluno;

@RestController
@RequestMapping("/aluno")
@CrossOrigin("${origem-permitida}")
public class AlunoResource {
	
	@Autowired
	private AlunoBO alunoBO;
	
	@GetMapping
	public List<Aluno> listarTodos(){
		return alunoBO.ListarTodosAlunos();
	}
	
	@GetMapping("/{id}")
	public Aluno listarPorId(@PathVariable @Valid Long id){
		return alunoBO.buscarPorId(id);
	}
	
	@PostMapping("/{email}/{senha}")
	public Aluno cadastrarLogin(@PathVariable String email, @PathVariable String senha){
		Aluno aluno = new Aluno();
		aluno.setEmail(email);
		aluno.setSenha(senha);
		return alunoBO.adicionarAluno(aluno);
	}
	
	@PutMapping("/{id}/{nomeAluno}/{peso}/{altura}/{matricula}")
	public Aluno adicionar(
			@PathVariable Long id,
			@PathVariable String nomeAluno,
			@PathVariable float peso,
			@PathVariable float altura,
			@PathVariable String matricula){
		Aluno aluno = alunoBO.buscarPorId(id);
		aluno.setNomeAluno(nomeAluno);
		aluno.setPeso(peso);
		aluno.setAltura(altura);
		aluno.setMatricula(matricula);		
		return alunoBO.adicionarAluno(aluno);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id){
		Aluno aluno = alunoBO.buscarPorId(id);
		if (aluno == null) {
			ResponseEntity.notFound().build();
		}
		alunoBO.removerAluno(aluno.getId());
		return ResponseEntity.noContent().build();
	}

}
