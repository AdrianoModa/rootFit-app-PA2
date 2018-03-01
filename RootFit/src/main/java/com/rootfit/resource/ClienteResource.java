package com.rootfit.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rootfit.BO.ClienteBO;
import com.rootfit.model.Cliente;

@RestController
@RequestMapping("/cliente")
public class ClienteResource {
	
	@Autowired
	private ClienteBO clienteBO;
	
	@GetMapping
	public List<Cliente> listarTodos(){
		return clienteBO.ListarTodosClientes();
	}
	
	@PostMapping("/adicionar/{nomeAluno}/{peso}/{altura}/{matricula}")
	public Cliente adicionar(
			@PathVariable String nomeAluno,
			@PathVariable float peso,
			@PathVariable float altura,
			@PathVariable String matricula){
		Cliente cliente = new Cliente();
		cliente.setNomeAluno(nomeAluno);
		cliente.setPeso(peso);
		cliente.setAltura(altura);
		cliente.setMatricula(matricula);		
		return clienteBO.adicionarCliente(cliente);
	}

}
