package com.rootfit.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rootfit.BO.InstrutorBO;
import com.rootfit.model.Instrutor;

@RestController
@RequestMapping(value="/instrutor")
public class InstrutorResource {
	
	@Autowired
	InstrutorBO instBO;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Long id){
		Instrutor obj = instBO.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<Instrutor> obj = instBO.listarTodos();
		return ResponseEntity.ok().body(obj);
		
	}
	
	@RequestMapping(value="/newInstrutor", method=RequestMethod.POST)
		public ResponseEntity<?> persistInstrutor(@RequestBody Instrutor instrutor){
		instBO.adiciona(instrutor);
		return ResponseEntity.status(HttpStatus.CREATED).build();
		
		}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<?> putInstrutor(@PathVariable Long id, @RequestBody Instrutor instrutor){
		Instrutor update = instBO.buscarPorId(id);
		update.setNome(instrutor.getNome());
		update.setSenha(instrutor.getSenha());
		instBO.atualizar(update);
		return ResponseEntity.ok().body(instrutor);
	}
		
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteInstrutor(@PathVariable Long id){
		Instrutor inst = instBO.buscarPorId(id);
		instBO.remover(id);
		return ResponseEntity.ok().build();
		
	}

}
