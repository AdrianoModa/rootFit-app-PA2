package com.rootfit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rootfit.model.MedidaMuscular;
import com.rootfit.repositories.MedidaMuscularRepository;

@Service
public class MedidaMuscularService {
	
	@Autowired
	private MedidaMuscularRepository medidaMuscularRepository;
	
	public MedidaMuscular adicionarMedidaMuscular(MedidaMuscular medidaMuscular){
		return medidaMuscularRepository.save(medidaMuscular);
	}
	
	public MedidaMuscular atualizarMedidaMuscular(MedidaMuscular medidaMuscular){
		MedidaMuscular medidaMuscularExistente = medidaMuscularRepository.findOne(medidaMuscular.getId());
		return medidaMuscularRepository.save(medidaMuscularExistente);
	}
	
	public MedidaMuscular buscarPorId(Long id){		
		return medidaMuscularRepository.findOne(id);
	}
	
	public void removerMedidaMuscular(Long id){
		MedidaMuscular medidaMuscularExistente = medidaMuscularRepository.findOne(id);
		medidaMuscularRepository.delete(medidaMuscularExistente);
	}	
	
	public List<MedidaMuscular> listarTodos(){
		return medidaMuscularRepository.findAll();
	}
}
