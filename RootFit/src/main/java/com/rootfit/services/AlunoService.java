package com.rootfit.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rootfit.model.Aluno;
import com.rootfit.repositories.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	public Boolean compare_matricula(String matricula) {
		Optional<Aluno> aluno = alunoRepository.findAlunoByMatricula(matricula);
		if (aluno.isPresent()) {
			return true;
		} else {
			return false;
		}
	}

	public Aluno adicionarAluno(Aluno aluno){
		return alunoRepository.save(aluno);
	}
	
	public Aluno atualizarAluno(Aluno aluno){
		Aluno clienteExistente = alunoRepository.findOne(aluno.getId());	
		return alunoRepository.save(clienteExistente);
	}
	
	public Aluno buscarPorId(Long id){
		return alunoRepository.findOne(id);
	}
	
	public void removerAluno(Long id){
		Aluno aluno = alunoRepository.findOne(id);
		alunoRepository.delete(aluno);
	}
	
	public List<Aluno> ListarTodosAlunos(){
		return alunoRepository.findAll();
	}
	
}
