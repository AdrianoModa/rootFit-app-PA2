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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rootfit.model.Colaborador;
import com.rootfit.repositories.ColaboradorRepository;
import com.rootfit.services.ColaboradorService;

@RestController
@RequestMapping("/colaborador")
@CrossOrigin("${origem-permitida}")
public class ColaboradorController {
	
	@Autowired
	private ColaboradorRepository colaboradorRepository;
	@Autowired
	private ColaboradorService colaboradorService;
	
	@GetMapping
	//@PreAuthorize("hasAuthority('ROLE_PESQUISAR_COLABORADOR') and #oauth2.hasScope('read')")
	public List<Colaborador> listar() {
		return colaboradorRepository.findAll();
	}
	
	@GetMapping("/{id}")
	//@PreAuthorize("hasAuthority('ROLE_PESQUISAR_COLABORADOR') and #oauth2.hasScope('read')")
	public ResponseEntity<Colaborador> listarPorId(@PathVariable Long id) {
		Colaborador colaborador  = colaboradorRepository.findOne(id);
		return colaborador != null ? ResponseEntity.ok(colaborador) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	//@PreAuthorize("hasAuthority('ROLE_CADASTRAR_COLABORADOR') and #oauth2.hasScope('write')")
	public Colaborador adicionar(@RequestBody Colaborador colaborador) {
		colaborador.setMatricula(colaboradorService.gerarMatricula());
		String crptoPwd = colaboradorService.cyptoPwd(colaborador.getSenha());
		colaborador.setSenha(crptoPwd);
		return colaboradorService.adicionarColaborador(colaborador);
		
	}
	
	@DeleteMapping("/colaborador/{id}")
	//@PreAuthorize("hasAuthority('ROLE_REMOVER_COLABORADOR') and #oauth2.hasScope('write')")
	public void remover(@PathVariable Long id) {
		colaboradorRepository.delete(id);
	}

	@PutMapping("colaborador/{id}")
	public ResponseEntity<Colaborador> atualizar(@PathVariable Long id, @Valid @RequestBody Colaborador colaborador){
		Colaborador colaboradorSalvo = colaboradorService.atualizarColaborador(id, colaborador);
		return ResponseEntity.ok(colaboradorSalvo);
	}
}
