package com.rootfit.controllers;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

	@Autowired
	private ApplicationEventPublisher publisher;

	@Autowired
	private MessageSource messageSource;
	
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
	
//	@PostMapping
//	//@PreAuthorize("hasAuthority('ROLE_CADASTRAR_COLABORADOR') and #oauth2.hasScope('write')")
//	public Colaborador adicionar( @Valid @RequestBody Colaborador colaborador) {
//		colaborador.setMatricula(colaboradorService.gerarMatricula());
//		String crptoPwd = colaboradorService.cyptoPwd(colaborador.getSenha());
//		colaborador.setSenha(crptoPwd);
//		return colaboradorService.adicionarColaborador(colaborador);
//
//	}
	@PostMapping
    public ResponseEntity<Colaborador> adicionar(@Valid @RequestBody Colaborador colaborador, HttpServletResponse response) {
        Colaborador colaboradorSalvo = colaboradorService.adicionarColaborador(colaborador);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(colaboradorSalvo.getId()).toUri();
        response.setHeader("Location", uri.toASCIIString());

        return ResponseEntity.created(uri).body(colaboradorSalvo);
    }
	
	@DeleteMapping("/{id}")
	//@PreAuthorize("hasAuthority('ROLE_REMOVER_COLABORADOR') and #oauth2.hasScope('write')")
	public void remover(@PathVariable Long id) {
		colaboradorRepository.delete(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Colaborador> atualizar(@PathVariable Long id, @Valid @RequestBody Colaborador colaborador){
		Colaborador colaboradorSalvo = colaboradorService.atualizarColaborador(id, colaborador);
		return ResponseEntity.ok(colaboradorSalvo);
	}
}
