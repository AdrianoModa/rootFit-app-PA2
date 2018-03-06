package com.rootfit.BO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rootfit.DAO.AlunoDAO;
import com.rootfit.model.Aluno;

@Service
public class AlunoBO {
	
	@Autowired
	private AlunoDAO alunoDAO;

	public Aluno adicionarAluno(Aluno aluno){
		return alunoDAO.save(aluno);
	}
	
	public Aluno atualizarAluno(Aluno aluno){
		Aluno clienteExistente = alunoDAO.findOne(aluno.getId());	
		return alunoDAO.save(clienteExistente);
	}
	
	public Aluno buscarPorId(Long id){
		return alunoDAO.findOne(id);
	}
	
	public void removerAluno(Long id){
		Aluno aluno = alunoDAO.findOne(id);
		alunoDAO.delete(aluno);
	}
	
	public List<Aluno> ListarTodosAlunos(){
		return alunoDAO.findAll();
	}
	
}
