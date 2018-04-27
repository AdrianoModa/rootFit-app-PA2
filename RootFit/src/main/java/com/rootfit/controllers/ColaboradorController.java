package com.rootfit.controllers;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@CrossOrigin("${origem-permitida}")
public class ColaboradorController {
	
	@Autowired
	private ColaboradorRepository colaboradorRepository;
	
	@Autowired
	private ColaboradorService colaboradorService;
	
	@GetMapping("/colaborador")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_COLABORADOR') and #oauth2.hasScope('read')")
	public List<Colaborador> listar() {
		return colaboradorRepository.findAll();
	}
	
	@GetMapping("/colaborador/{id}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_COLABORADOR') and #oauth2.hasScope('read')")
	public ResponseEntity<Colaborador> listarPorId(@PathVariable Long id) {
		Colaborador colaborador  = colaboradorRepository.findOne(id);
		return colaborador != null ? ResponseEntity.ok(colaborador) : ResponseEntity.notFound().build();
	}
	
	@PostMapping("/colaborador")
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_COLABORADOR') and #oauth2.hasScope('write')")
	public void adicionar(@RequestBody @Valid Colaborador colaborador, HttpServletResponse response) {
		Colaborador colaboradorSalvo = colaboradorRepository.save(colaborador);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(colaboradorSalvo.getId()).toUri();
		response.setHeader("Location", uri.toASCIIString());
	}
	
	@DeleteMapping("/colaborador/{id}")
	@PreAuthorize("hasAuthority('ROLE_REMOVER_COLABORADOR') and #oauth2.hasScope('write')")
	public void remover(@PathVariable Long id) {
		colaboradorRepository.delete(id);
	}

	@PutMapping("colaborador/{id}")
	public ResponseEntity<Colaborador> atualizar(@PathVariable Long id, @Valid @RequestBody Colaborador colaborador){
		Colaborador colaboradorSalvo = colaboradorService.atualizarColaborador(id, colaborador);
		return ResponseEntity.ok(colaboradorSalvo);
	}
	
	
	
	
	

}
