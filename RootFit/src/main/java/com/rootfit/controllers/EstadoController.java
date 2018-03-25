package com.rootfit.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rootfit.model.Estado;
import com.rootfit.services.EstadoService;

@RestController
@RequestMapping("/estado")
@CrossOrigin("${origem-permitida}")
public class EstadoController {
	
	@Autowired
	private EstadoService estadoService;
	
	@GetMapping
	public List<Estado> listarTodos(){
		return estadoService.listarTodosEstados();
	}
	
	@GetMapping("/{id}")
	public Estado listarPorId(@PathVariable @Valid Long id){
		return estadoService.buscarPorId(id);
	}
	
	@PostMapping
	public Estado adicionar(@RequestBody Estado estado){
		return estadoService.adicionarEstado(estado);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Estado> atualizar(@PathVariable Long id, @RequestBody Estado estado){
		Estado estadoExistente = estadoService.buscarPorId(id);
		if(estadoExistente == null){
			ResponseEntity.notFound().build();
		}
		BeanUtils.copyProperties(estado, estadoExistente, "id");
		estado = estadoService.atualizarEstado(estadoExistente);
		return ResponseEntity.ok(estado);
	}
	
	public ResponseEntity<Void> remover(@PathVariable Long id){
		Estado estadoExistente = estadoService.buscarPorId(id);
		if(estadoExistente == null){
			ResponseEntity.notFound().build();
		}
		estadoService.removerEstado(estadoExistente.getId());
		return ResponseEntity.noContent().build();		
	}

}
