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

import com.rootfit.model.MedidaMuscular;
import com.rootfit.services.MedidaMuscularService;

@RestController
@RequestMapping("/medida-muscular")
@CrossOrigin("${origem-permitida}")
public class MedidaMuscularController {
	
	@Autowired
	private MedidaMuscularService medidaMuscularService;

	@GetMapping
	public List<MedidaMuscular> listarTodos(){
		return medidaMuscularService.listarTodos();
	}
	
	@GetMapping("/{id}")
	public MedidaMuscular listarPorId(@RequestBody @Valid Long id){
		return medidaMuscularService.buscarPorId(id);
	}
	
	@PostMapping
	public MedidaMuscular adicionar(@RequestBody MedidaMuscular medidaMuscular){
		return medidaMuscularService.adicionarMedidaMuscular(medidaMuscular);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<MedidaMuscular> atualizar(@PathVariable Long id, @RequestBody MedidaMuscular medidaMuscular){
		MedidaMuscular medidaMuscularExistente = medidaMuscularService.buscarPorId(id);
		if (medidaMuscularExistente == null) {
			ResponseEntity.notFound().build();
		}
		BeanUtils.copyProperties(medidaMuscular, medidaMuscularExistente, "id");
		medidaMuscular = medidaMuscularService.atualizarMedidaMuscular(medidaMuscularExistente);
		return ResponseEntity.ok(medidaMuscular);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id){
		MedidaMuscular medidaMuscularExistente = medidaMuscularService.buscarPorId(id);
		if (medidaMuscularExistente == null) {
			ResponseEntity.notFound().build();
		}
		medidaMuscularService.removerMedidaMuscular(medidaMuscularExistente.getId());
		return ResponseEntity.noContent().build();
	}
}