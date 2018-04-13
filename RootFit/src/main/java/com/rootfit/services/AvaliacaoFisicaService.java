package com.rootfit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rootfit.model.AvaliacaoFisica;
import com.rootfit.repositories.AvaliacaoFisicaRepository;

@Service
public class AvaliacaoFisicaService {
	
	@Autowired
	private AvaliacaoFisicaRepository avaliacaoFisicaDAO;

	public AvaliacaoFisica adicionarAvaliacaoFisica(AvaliacaoFisica avaliacaoFisica){
		return avaliacaoFisicaDAO.save(avaliacaoFisica);
	}
	
	public AvaliacaoFisica atualizarAvaliacaoFisica(AvaliacaoFisica avaliacaoFisica){
		AvaliacaoFisica clienteExistente = avaliacaoFisicaDAO.findOne(avaliacaoFisica.getId());	
		return avaliacaoFisicaDAO.save(clienteExistente);
	}
	
	public AvaliacaoFisica buscarPorId(Long id){
		return avaliacaoFisicaDAO.findOne(id);
	}
	
	public void removerAvaliacaoFisica(Long id){
		AvaliacaoFisica avaliacaoFisica = avaliacaoFisicaDAO.findOne(id);
		avaliacaoFisicaDAO.delete(avaliacaoFisica);
	}
	
	public List<AvaliacaoFisica> ListarTodosAvaliacaoFisicas(){
		return avaliacaoFisicaDAO.findAll();
	}
	
}
