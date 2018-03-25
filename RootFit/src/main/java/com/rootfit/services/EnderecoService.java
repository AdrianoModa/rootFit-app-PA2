package com.rootfit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rootfit.model.Endereco;
import com.rootfit.repositories.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public Endereco adicionarEndereco(Endereco endereco){
		return enderecoRepository.save(endereco);
	}
	
	public Endereco atualizarEndereco(Endereco endereco){
		Endereco enderecoExistente = enderecoRepository.findOne(endereco.getId());
		return enderecoRepository.save(enderecoExistente);
	}
	
	public Endereco buscarPorId(Long id){
		return enderecoRepository.findOne(id);
	}
	
	public void removerEndereco(Long id){
		Endereco endereco = enderecoRepository.findOne(id);
		enderecoRepository.delete(endereco);
	}
	
	public List<Endereco> listarTodosEnderecos(){
		return enderecoRepository.findAll();
	}
}
