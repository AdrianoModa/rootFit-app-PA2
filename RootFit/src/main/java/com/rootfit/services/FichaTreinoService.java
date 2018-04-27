package com.rootfit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rootfit.model.FichaTreino;
import com.rootfit.repositories.FichaTreinoRepository;

@Service
public class FichaTreinoService {
	
	@Autowired
	private FichaTreinoRepository fichaTreinoRepository;
	
	public FichaTreino adicionarFichaTreino(FichaTreino fichaTreino){
		return fichaTreinoRepository.save(fichaTreino);
	}
	
	public FichaTreino atualizarFichaTreino(FichaTreino fichaTreino){
		FichaTreino fichaTreinoExistente = fichaTreinoRepository.findOne(fichaTreino.getId());
		return fichaTreinoRepository.save(fichaTreinoExistente);
	}
	
	public FichaTreino buscarPorId(Long id){
		return fichaTreinoRepository.findOne(id);
	}
	
	public void removerFichaTreino(Long id){
		FichaTreino fichaTreino = fichaTreinoRepository.findOne(id);
		fichaTreinoRepository.delete(fichaTreino);
	}
	
	public List<FichaTreino> listarTodasFichaTreino(){
		return fichaTreinoRepository.findAll();
	}
}
