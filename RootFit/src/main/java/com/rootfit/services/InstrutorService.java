package com.rootfit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rootfit.model.Instrutor;
import com.rootfit.repositories.InstrutorRepository;

@Service
public class InstrutorService {
	
	@Autowired
	private InstrutorRepository instrutorDAO;
	
	public Instrutor adiciona(Instrutor inst){
		return instrutorDAO.save(inst);
	}
	
	public Instrutor atualizar(Instrutor inst){
		Instrutor instCadastrado = instrutorDAO.findOne(inst.getId());	
		return instrutorDAO.save(instCadastrado);
	}
	
	public Instrutor buscarPorId(Long id){
		return instrutorDAO.findOne(id);
	}
	
	public void remover(Long id){
		Instrutor aluno = instrutorDAO.findOne(id);
		instrutorDAO.delete(aluno);
	}
	
	public List<Instrutor> listarTodos(){
		return instrutorDAO.findAll();
	}
	
}
