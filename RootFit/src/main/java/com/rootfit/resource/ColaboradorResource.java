package com.rootfit.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rootfit.DAO.ColaboradorDAO;
import com.rootfit.model.Colaborador;

@RestController
@CrossOrigin("${origem-permitida}")
public class ColaboradorResource {
	
	@Autowired
	private ColaboradorDAO colaboradorDAO;
	
	@GetMapping("/colaborador")
	public List<Colaborador> listar() {
		return colaboradorDAO.findAll();
	}
	
	@PostMapping("/colaborador")
	public Colaborador adicionar(@RequestBody @Valid Colaborador colaborador) {
		return colaboradorDAO.save(colaborador);
		
	}
	
	
	

}
