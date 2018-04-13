package com.rootfit.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rootfit.model.Exercicio;
import com.rootfit.services.ExercicioService;

@RestController
@RequestMapping(value="/exercicio")
public class ExercicioController {

	@Autowired
	ExercicioService exercicioService;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Long id){
		Exercicio obj = exercicioService.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<Exercicio> obj = exercicioService.listarTodos();
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value="/newExercicio", method=RequestMethod.POST)
	public ResponseEntity<?> persistExercicio(@RequestBody Exercicio exercicio){
		exercicioService.adiciona(exercicio);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Exercicio> atualizar(@PathVariable Long id, @RequestBody Exercicio exercicio){
		Exercicio exercicioExistente = exercicioService.buscarPorId(id);
		if (exercicioExistente == null) {
			ResponseEntity.notFound().build();
		}
		BeanUtils.copyProperties(exercicio, exercicioExistente, "id");
		exercicio = exercicioService.atualizar(exercicioExistente);
		return ResponseEntity.ok(exercicio);
	}

	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteExercicio(@PathVariable Long id){
		@SuppressWarnings("unused")
		Exercicio inst = exercicioService.buscarPorId(id);
		exercicioService.remover(id);
		return ResponseEntity.ok().build();

	}

}
