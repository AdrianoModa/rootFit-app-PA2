package com.rootfit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rootfit.model.Instrutor;
import com.rootfit.repositories.InstrutorRepository;

@Service
public class InstrutorService extends UsuarioService{
	
	@Autowired
	private InstrutorRepository instrutorRepository;
	
	public Instrutor adiciona(Instrutor inst){
		inst.setMatricula(gerarMatricula());
		String crpto = cyptoPwd(inst.getSenha());
		inst.setMatricula(crpto);
		return instrutorRepository.save(inst);
	}
	
	public Instrutor atualizar(Instrutor inst){
		Instrutor instCadastrado = instrutorRepository.findOne(inst.getId());	
		return instrutorRepository.save(instCadastrado);
	}
	
	public Instrutor buscarPorId(Long id){
		return instrutorRepository.findOne(id);
	}
	
	public void remover(Long id){
		Instrutor aluno = instrutorRepository.findOne(id);
		instrutorRepository.delete(aluno);
	}
	
	public List<Instrutor> listarTodos(){
		return instrutorRepository.findAll();
	}
	
}
