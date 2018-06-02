package com.rootfit.controllers;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rootfit.model.Instrutor;
import com.rootfit.services.InstrutorService;

@RestController
@RequestMapping(value="/instrutor")
public class InstrutorController {

	@Autowired
	InstrutorService instrutorService;
	
	@Autowired
	BCryptPasswordEncoder encoder;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Long id){
		Instrutor obj = instrutorService.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<Instrutor> obj = instrutorService.listarTodos();
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Instrutor> persistInstrutor(@RequestBody @Valid Instrutor instrutor, HttpServletResponse response){
		Instrutor instrutorSalvo = instrutorService.adiciona(instrutor);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(instrutorSalvo.getId()).toUri();
        response.setHeader("Location", uri.toASCIIString());
        return ResponseEntity.created(uri).body(instrutorSalvo);
	}

	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Instrutor> atualizar(@PathVariable Long id, @RequestBody Instrutor instrutor){
		Instrutor instrutorExistente = instrutorService.buscarPorId(id);
		if (instrutorExistente == null) {
			ResponseEntity.notFound().build();
		}
		BeanUtils.copyProperties(instrutor, instrutorExistente, "id");
		instrutor = instrutorService.atualizar(instrutorExistente);
		return ResponseEntity.ok(instrutor);
	}

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteInstrutor(@PathVariable Long id){
		@SuppressWarnings("unused")
		Instrutor inst = instrutorService.buscarPorId(id);
		instrutorService.remover(id);
		return ResponseEntity.ok().build();

	}

}
