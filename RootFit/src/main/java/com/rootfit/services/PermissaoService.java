package com.rootfit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rootfit.model.Permissao;
import com.rootfit.repositories.PermissaoRepository;

@Service
public class PermissaoService {

	@Autowired
	private PermissaoRepository permissaoRepository;
	
	public Permissao adicionarPermissao(Permissao permissao){
		return permissaoRepository.save(permissao);
	}
	
	public Permissao atualizarPermissao(Permissao permissao){
		Permissao permissaoExistente = permissaoRepository.findOne(permissao.getId());
		return permissaoRepository.save(permissaoExistente);
	}
	
	public Permissao buscarPorId(Long id){
		return permissaoRepository.findOne(id);
	}
	
	public void removerPermissao(Long id){
		Permissao permissao = permissaoRepository.findOne(id);
		permissaoRepository.delete(permissao);
	}
	
	public List<Permissao> listarTodasPermissoes(){
		return permissaoRepository.findAll();
	}
	
}
