package com.rootfit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rootfit.model.Instrutor;
import com.rootfit.services.InstrutorService;

@RestController
@RequestMapping(value="/instrutor")
public class InstrutorController {
	
	@Autowired
	InstrutorService instrutorService;
	
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
	
	@RequestMapping(value="/newInstrutor", method=RequestMethod.POST)
		public ResponseEntity<?> persistInstrutor(@RequestBody Instrutor instrutor){
		instrutorService.adiciona(instrutor);
		return ResponseEntity.status(HttpStatus.CREATED).build();
		}
		
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteInstrutor(@PathVariable Long id){
		Instrutor inst = instrutorService.buscarPorId(id);
		instrutorService.remover(id);
		return ResponseEntity.ok().build();
		
	}

}
