package com.rootfit.BO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rootfit.DAO.ClienteDAO;
import com.rootfit.model.Cliente;

@Service
public class ClienteBO {
	
	@Autowired
	private ClienteDAO clienteDAO;

	public Cliente adicionarCliente(Cliente cliente){
		return clienteDAO.save(cliente);
	}
	
	public Cliente atualizarCliente(Long id){
		Cliente cliente = clienteDAO.findOne(id);
		return clienteDAO.save(cliente);
	}
	
	public Cliente buscarPorId(Long id){
		return clienteDAO.findOne(id);
	}
	
	public void removerCliente(Long id){
		Cliente cliente = clienteDAO.findOne(id);
		clienteDAO.delete(cliente);
	}
	
	public List<Cliente> ListarTodosClientes(){
		return clienteDAO.findAll();
	}
	
}
