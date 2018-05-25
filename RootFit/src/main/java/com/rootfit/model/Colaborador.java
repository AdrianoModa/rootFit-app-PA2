package com.rootfit.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table
public class Colaborador implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private String senha;
	
	
	public Colaborador() {
		
	}
	
	public Colaborador(Long id, String nome, String email, String telefone, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
		//this.tipo = tipo.getCod();
//		this.empresa = empresa;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	@NotEmpty
	@Size(min = 5, max = 30)
	@Column
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	@NotEmpty
	@Column
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@NotEmpty
	@Column
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@NotEmpty
	@Column
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Colaborador other = (Colaborador) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
