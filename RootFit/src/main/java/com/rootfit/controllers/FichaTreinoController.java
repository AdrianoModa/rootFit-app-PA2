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

import com.rootfit.model.FichaTreino;
import com.rootfit.services.FichaTreinoService;

@RestController
@RequestMapping("/ficha-treino")
@CrossOrigin("${origem-permitida}")
public class FichaTreinoController {
	
	@Autowired
	private FichaTreinoService fichaTreinoService;
	
	@GetMapping
	public List<FichaTreino> listarTodos(){
		return fichaTreinoService.listarTodasFichaTreino();
	}
	
	@GetMapping("/{id}")
	public FichaTreino listarPorId(@PathVariable @Valid Long id){
		return fichaTreinoService.buscarPorId(id);
	}
	
	@PostMapping
	public FichaTreino adicionar(@RequestBody FichaTreino fichaTreino){
		return fichaTreinoService.adicionarFichaTreino(fichaTreino);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<FichaTreino> atualizar(@PathVariable Long id, @RequestBody FichaTreino fichaTreino){
		FichaTreino fichaTreinoExistente = fichaTreinoService.buscarPorId(id);
		if (fichaTreinoExistente == null) {
			ResponseEntity.notFound().build();
		}
		BeanUtils.copyProperties(fichaTreino, fichaTreinoExistente, "id");
		fichaTreino = fichaTreinoService.atualizarFichaTreino(fichaTreinoExistente);
		return ResponseEntity.ok(fichaTreino);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id){
		FichaTreino fichaTreinoExistente = fichaTreinoService.buscarPorId(id);
		if (fichaTreinoExistente == null) {
			ResponseEntity.notFound().build();
		}
		fichaTreinoService.removerFichaTreino(fichaTreinoExistente.getId());
		return ResponseEntity.noContent().build();
	}
}