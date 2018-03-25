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

import com.rootfit.model.Cidade;
import com.rootfit.services.CidadeService;

@RestController
@RequestMapping("/cidade")
@CrossOrigin("${origem-permitida}")
public class CidadeController {
	
	@Autowired
	private CidadeService cidadeService;

	@GetMapping
	public List<Cidade> listarTodos(){
		return cidadeService.listarTodasCidades();
	}
	
	@GetMapping("/{id}")
	public Cidade listarPorId(@PathVariable @Valid Long id){
		return cidadeService.buscarPorId(id);
	}
	
	@PostMapping("/adicionar")
	public Cidade adicionar(@RequestBody Cidade cidade){
		return cidadeService.adicionarCidade(cidade);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cidade> atualizar(@PathVariable Long id, @RequestBody Cidade cidade){
		Cidade cidadeExistente = cidadeService.buscarPorId(id);
		if(cidadeExistente == null){
			ResponseEntity.notFound().build();
		}
		BeanUtils.copyProperties(cidade, cidadeExistente, "id");
		cidade = cidadeService.atualizarCidade(cidadeExistente);
		return ResponseEntity.ok(cidade);
	}
	
	public ResponseEntity<Void> remover(@PathVariable Long id){
		Cidade cidadeExistente = cidadeService.buscarPorId(id);
		if(cidadeExistente == null){
			ResponseEntity.notFound().build();
		}
		cidadeService.removerCidade(cidadeExistente.getId());
		return ResponseEntity.noContent().build();		
	}
	
}
