package com.rootfit.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rootfit.model.Colaborador;
import com.rootfit.repositories.ColaboradorRepository;
import com.rootfit.services.ColaboradorService;

@RestController
@CrossOrigin("${origem-permitida}")
public class ColaboradorController {
	
	@Autowired
	private ColaboradorRepository colaboradorDAO;
	
	@Autowired
	private ColaboradorService colaboradorService;
	
	@GetMapping("/colaborador")
	public List<Colaborador> listar() {
		return colaboradorDAO.findAll();
	}
	
	@GetMapping("/colaborador/{id}")
	public ResponseEntity<Colaborador> listarPorId(@PathVariable Long id) {
		Colaborador colaborador  = colaboradorDAO.findOne(id);
		return colaborador != null ? ResponseEntity.ok(colaborador) : ResponseEntity.notFound().build();
	}
	
	@PostMapping("/colaborador")
	public Colaborador adicionar(@RequestBody @Valid Colaborador colaborador) {
		return colaboradorDAO.save(colaborador);
	}
	
	@DeleteMapping("/colaborador/{id}")
	public void remover(@PathVariable Long id) {
		colaboradorDAO.delete(id);
	}

	@PutMapping("colaborador/{id}")
	public ResponseEntity<Colaborador> atualizar(@PathVariable Long id, @Valid @RequestBody Colaborador colaborador){
		Colaborador colaboradorSalvo = colaboradorService.atualizarColaborador(id, colaborador);
		return ResponseEntity.ok(colaboradorSalvo);
	}
	
	
	
	
	

}
