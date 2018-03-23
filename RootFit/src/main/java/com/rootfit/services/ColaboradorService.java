package com.rootfit.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rootfit.model.Colaborador;
import com.rootfit.repositories.ColaboradorRepository;

@Service
public class ColaboradorService {
	
	@Autowired
	private ColaboradorRepository colaboradorDAO;

	public Colaborador adicionarColaborador(Colaborador colaborador){
		return colaboradorDAO.save(colaborador);
	}
	
	public Colaborador atualizarColaborador(Long id, Colaborador colaborador){
		Colaborador colaboradorSalvo = colaboradorDAO.findOne(id);
		BeanUtils.copyProperties(colaborador, colaboradorSalvo, "id");
		return colaboradorDAO.save(colaboradorSalvo);
	}
	
	public Colaborador buscarPorId(Long id){
		return colaboradorDAO.findOne(id);
	}
	
	public void removerColaborador(Long id){
		Colaborador colaborador = colaboradorDAO.findOne(id);
		colaboradorDAO.delete(colaborador);
	}
	
	public List<Colaborador> ListarTodosColaborador(){
		return colaboradorDAO.findAll();
	}
	
}