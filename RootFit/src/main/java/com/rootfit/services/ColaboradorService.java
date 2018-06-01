package com.rootfit.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rootfit.model.Colaborador;
import com.rootfit.repositories.ColaboradorRepository;

@Service
public class ColaboradorService extends UsuarioService{
	
	@Autowired
	private ColaboradorRepository colaboradorRepository;

	public Colaborador adicionarColaborador(Colaborador colaborador){
		colaborador.setMatricula(gerarMatricula());
		String crptoPwd = cyptoPwd(colaborador.getSenha());
		colaborador.setSenha(crptoPwd);

		return colaboradorRepository.save(colaborador);
	}
	
	public Colaborador atualizarColaborador(Long id, Colaborador colaborador){
		Colaborador colaboradorSalvo = colaboradorRepository.findOne(id);
		BeanUtils.copyProperties(colaborador, colaboradorSalvo, "id");
		return colaboradorRepository.save(colaboradorSalvo);
	}
	
	public Colaborador buscarPorId(Long id){
		return colaboradorRepository.findOne(id);
	}
	
	public void removerColaborador(Long id){
		Colaborador colaborador = colaboradorRepository.findOne(id);
		colaboradorRepository.delete(colaborador);
	}
	
	public List<Colaborador> ListarTodosColaborador(){
		return colaboradorRepository.findAll();
	}
	
}