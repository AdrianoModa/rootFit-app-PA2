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

import com.rootfit.model.Endereco;
import com.rootfit.services.EnderecoService;

@RestController
@RequestMapping("/endereco")
@CrossOrigin("${origem-permitida}")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;

	@GetMapping
	public List<Endereco> listarTodos(){
		return enderecoService.listarTodosEnderecos();
	}

	@GetMapping("{id}")
	public Endereco listarPorId(@PathVariable @Valid Long id){
		return enderecoService.buscarPorId(id);
	}

	@PostMapping
	public Endereco adicionar(@RequestBody Endereco endereco){
		return enderecoService.adicionarEndereco(endereco);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Endereco> atualizar(@PathVariable Long id, @RequestBody Endereco endereco){
		Endereco enderecoExistente = enderecoService.buscarPorId(id);
		if(enderecoExistente == null){
			ResponseEntity.notFound().build();
		}
		BeanUtils.copyProperties(endereco, enderecoExistente, "id");
		endereco = enderecoService.atualizarEndereco(enderecoExistente);
		return ResponseEntity.ok(endereco);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id){
		Endereco enderecoExistente = enderecoService.buscarPorId(id);
		if(enderecoExistente == null){
			ResponseEntity.notFound().build();
		}
		enderecoService.removerEndereco(enderecoExistente.getId());
		return ResponseEntity.noContent().build();
	}

}
