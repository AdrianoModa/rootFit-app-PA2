package com.rootfit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rootfit.model.Cidade;
import com.rootfit.repositories.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	public Cidade adicionarCidade(Cidade cidade){
		return cidadeRepository.save(cidade);
	}
	
	public Cidade atualizarCidade(Cidade cidade){
		Cidade cidadeExistente = cidadeRepository.findOne(cidade.getId());
		return cidadeRepository.save(cidadeExistente);
	}
	
	public Cidade buscarPorId(Long id){
		return cidadeRepository.findOne(id);
	}
	
	public void removerCidade(Long id){
		Cidade cidade = cidadeRepository.findOne(id);
		cidadeRepository.delete(cidade);
	}
	
	public List<Cidade> listarTodasCidades(){
		return cidadeRepository.findAll();
	}
}
