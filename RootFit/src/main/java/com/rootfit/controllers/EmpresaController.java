package com.rootfit.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rootfit.model.Empresa;
import com.rootfit.services.EmpresaService;

@RestController
@RequestMapping("/empresa")
@CrossOrigin("${origem-permitida}")
public class EmpresaController {
	
	@Autowired
	private EmpresaService empresaService;
	
	@GetMapping
	public List<Empresa> listarTodos(){
		return empresaService.listarTodasEmpresas();
	}
	
	@GetMapping("/{id}")
	public Empresa listarPorId(@PathVariable @Valid Long id){
		return empresaService.buscarPorId(id);
	}
	
	@PostMapping
	public Empresa adicionar(@RequestBody Empresa empresa){
		return empresaService.adicionarEmpresa(empresa);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Empresa> atualizar(@PathVariable Long id, @RequestBody Empresa empresa){
		Empresa empresaExistente = empresaService.buscarPorId(id);
		if(empresaExistente == null){
			ResponseEntity.notFound().build();
		}
		BeanUtils.copyProperties(empresa, empresaExistente, "id");
		empresa = empresaService.atualizarEmpresa(empresaExistente);
		return ResponseEntity.ok(empresa);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id){
		Empresa empresaExistente = empresaService.buscarPorId(id);
		if(empresaExistente == null){
			ResponseEntity.notFound().build();
		}
		empresaService.removerEmpresa(empresaExistente.getId());
		return ResponseEntity.noContent().build();		
	}
}