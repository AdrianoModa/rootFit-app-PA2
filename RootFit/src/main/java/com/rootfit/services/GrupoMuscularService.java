package com.rootfit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rootfit.model.GrupoMuscular;
import com.rootfit.repositories.GrupoMuscularRepository;

@Service
public class GrupoMuscularService {
	
	@Autowired
	private GrupoMuscularRepository grupoMuscularRepository;

	public GrupoMuscular adicionarGrupoMuscular(GrupoMuscular grupoMuscular){
		return grupoMuscularRepository.save(grupoMuscular);
	}
	
	public GrupoMuscular atualizarGrupoMuscular(GrupoMuscular grupoMuscular){
		GrupoMuscular grupoMuscularExistente = grupoMuscularRepository.findOne(grupoMuscular.getId());
		return grupoMuscularRepository.save(grupoMuscularExistente);
	}
	
	public GrupoMuscular buscarPorId(Long id){
		return grupoMuscularRepository.findOne(id);
	}
	
	public void removerGrupoMuscular(Long id){
		GrupoMuscular grupoMuscular = grupoMuscularRepository.findOne(id);
		grupoMuscularRepository.delete(grupoMuscular);
	}
	
	public List<GrupoMuscular> listarTodosGrupoMuscular(){
		return grupoMuscularRepository.findAll();
	}
}
