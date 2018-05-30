package com.rootfit.model;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Colaborador extends Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String cargo;
	
	
	public Colaborador() {
		
	}
	
	public Colaborador(Long id) {
		super(id);
		
	}
		
	public Colaborador(Long id, String nome, String login, String senha, String cargo) {
		super(id, nome, login, senha);
		this.cargo = cargo;
	}
	
	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
}
