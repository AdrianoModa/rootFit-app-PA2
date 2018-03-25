package com.rootfit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rootfit.model.Estado;
import com.rootfit.repositories.EstadoRepository;

@Service
public class EstadoService {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	public Estado adicionarEstado(Estado estado){
		return estadoRepository.save(estado);
	}
	
	public Estado atualizarEstado(Estado estado){
		Estado estadoExistente = estadoRepository.findOne(estado.getId());
		return estadoRepository.save(estadoExistente);
	}
	
	public Estado buscarPorId(Long id){
		return estadoRepository.findOne(id);
	}
	
	public void removerEstado(Long id){
		Estado estado = estadoRepository.findOne(id);
		estadoRepository.delete(estado);
	}
	
	public List<Estado> listarTodosEstados(){
		return estadoRepository.findAll();
	}

}
