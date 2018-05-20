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

import com.rootfit.model.AvaliacaoFisica;
import com.rootfit.services.AvaliacaoFisicaService;

@RestController
@RequestMapping("/avaliacao-fisica")
@CrossOrigin("${origem-permitida}")
public class AvaliacaoController {
	
	@Autowired
	private AvaliacaoFisicaService avaliacaoFisicaService;
	
	@GetMapping
	public List<AvaliacaoFisica> listarTodos(){
		return avaliacaoFisicaService.ListarTodosAvaliacaoFisicas();
	}
	
	@GetMapping("/{id}")
	public AvaliacaoFisica listarPorId(@PathVariable @Valid Long id){
		return avaliacaoFisicaService.buscarPorId(id);
	}
	
	@PostMapping
	public AvaliacaoFisica cadastrarLogin(@RequestBody AvaliacaoFisica avaliacaoFisica){
		return avaliacaoFisicaService.adicionarAvaliacaoFisica(avaliacaoFisica);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AvaliacaoFisica> atualizar(@PathVariable Long id, @RequestBody AvaliacaoFisica avaliacaoFisica){
		AvaliacaoFisica avaliacaoFisicaExistente = avaliacaoFisicaService.buscarPorId(id);
		if (avaliacaoFisicaExistente == null) {
			ResponseEntity.notFound().build();
		}
		BeanUtils.copyProperties(avaliacaoFisica, avaliacaoFisicaExistente, "id");
		avaliacaoFisica = avaliacaoFisicaService.atualizarAvaliacaoFisica(avaliacaoFisicaExistente);
		return ResponseEntity.ok(avaliacaoFisica);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id){
		AvaliacaoFisica avaliacaoFisica = avaliacaoFisicaService.buscarPorId(id);
		if (avaliacaoFisica == null) {
			ResponseEntity.notFound().build();
		}
		avaliacaoFisicaService.removerAvaliacaoFisica(avaliacaoFisica.getId());
		return ResponseEntity.noContent().build();
	}

}
