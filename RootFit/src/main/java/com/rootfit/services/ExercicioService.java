package com.rootfit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rootfit.model.Exercicio;
import com.rootfit.repositories.ExercicioRepository;

@Service
public class ExercicioService {
	
	@Autowired
	private ExercicioRepository exercicioDAO;
	
	public Exercicio adiciona(Exercicio inst){
		return exercicioDAO.save(inst);
	}
	
	public Exercicio atualizar(Exercicio inst){
		Exercicio instCadastrado = exercicioDAO.findOne(inst.getId());	
		return exercicioDAO.save(instCadastrado);
	}
	
	public Exercicio buscarPorId(Long id){
		return exercicioDAO.findOne(id);
	}
	
	public void remover(Long id){
		Exercicio aluno = exercicioDAO.findOne(id);
		exercicioDAO.delete(aluno);
	}
	
	public List<Exercicio> listarTodos(){
		return exercicioDAO.findAll();
	}
	
}
