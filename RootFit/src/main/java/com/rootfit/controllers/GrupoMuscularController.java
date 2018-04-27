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

import com.rootfit.model.GrupoMuscular;
import com.rootfit.services.GrupoMuscularService;

@RestController
@RequestMapping("/grupo-muscular")
@CrossOrigin("${origem-permitida}")
public class GrupoMuscularController {

	@Autowired
	private GrupoMuscularService grupoMuscularService;

	@GetMapping
	public List<GrupoMuscular> listarTodos(){
		return grupoMuscularService.listarTodosGrupoMuscular();
	}

	@GetMapping("/{id}")
	public GrupoMuscular listarPorId(@PathVariable @Valid Long id){
		return grupoMuscularService.buscarPorId(id);
	}

	@PostMapping
	public GrupoMuscular adicionar(@RequestBody GrupoMuscular grupoMuscular){
		return grupoMuscularService.adicionarGrupoMuscular(grupoMuscular);
	}

	@PutMapping("/{id}")
	public ResponseEntity<GrupoMuscular> atualizar(@PathVariable Long id, @RequestBody GrupoMuscular grupoMuscular){
		GrupoMuscular grupoMuscularExistente = grupoMuscularService.buscarPorId(id);
		if (grupoMuscularExistente == null) {
			ResponseEntity.notFound().build();
		}
		BeanUtils.copyProperties(grupoMuscular, grupoMuscularExistente, "id");
		grupoMuscular = grupoMuscularService.atualizarGrupoMuscular(grupoMuscularExistente);
		return ResponseEntity.ok(grupoMuscular);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id){
		GrupoMuscular grupoMuscularExistente = grupoMuscularService.buscarPorId(id);
		if (grupoMuscularExistente == null) {
			ResponseEntity.notFound().build();
		}
		grupoMuscularService.removerGrupoMuscular(grupoMuscularExistente.getId());
		return ResponseEntity.noContent().build();
	}
}