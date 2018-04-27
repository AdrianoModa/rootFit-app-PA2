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

import com.rootfit.model.Permissao;
import com.rootfit.services.PermissaoService;

@RestController
@RequestMapping("/permissao")
@CrossOrigin("${origem-permitida}")
public class PermissaoController {
	
	@Autowired
	private PermissaoService permissaoService;
	
	@GetMapping
	public List<Permissao> listarTodos(){
		return permissaoService.listarTodasPermissoes();
	}
	
	@GetMapping("/{id}")
	public Permissao listarPorId(@PathVariable @Valid Long id){
		return permissaoService.buscarPorId(id);
	}
	
	@PostMapping
	public Permissao adicionar(@RequestBody Permissao permissao){
		return permissaoService.adicionarPermissao(permissao);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Permissao> atualizar(@PathVariable Long id, @RequestBody Permissao permissao){
		Permissao permissaoExistente = permissaoService.buscarPorId(id);
		if(permissaoExistente == null){
			ResponseEntity.notFound().build();
		}
		BeanUtils.copyProperties(permissao, permissaoExistente, "id");
		permissao = permissaoService.atualizarPermissao(permissaoExistente);
		return ResponseEntity.ok(permissao);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id){
		Permissao permissaoExistente = permissaoService.buscarPorId(id);
		if(permissaoExistente == null){
			ResponseEntity.notFound().build();
		}
		permissaoService.removerPermissao(permissaoExistente.getId());
		return ResponseEntity.noContent().build();
	}
}