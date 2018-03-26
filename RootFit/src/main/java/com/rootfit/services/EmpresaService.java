package com.rootfit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rootfit.model.Empresa;
import com.rootfit.repositories.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	public Empresa adicionarEmpresa(Empresa empresa){
		return empresaRepository.save(empresa);
	}
	
	public Empresa atualizarEmpresa(Empresa empresa){
		Empresa empresaExistente = empresaRepository.findOne(empresa.getId());
		return empresaRepository.save(empresaExistente);
	}
	
	public Empresa buscarPorId(Long id){
		return empresaRepository.findOne(id);
	}
	
	public void removerEmpresa(Long id){
		Empresa empresaExistente = empresaRepository.findOne(id);
		empresaRepository.delete(empresaExistente);
	}
	
	public List<Empresa> listarTodasEmpresas(){
		return empresaRepository.findAll();
	}
}
