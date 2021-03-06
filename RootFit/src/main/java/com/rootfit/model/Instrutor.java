package com.rootfit.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Instrutor extends Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy="instrutor")
	@JsonIgnore
	private List<Aluno> alunos = new ArrayList<>();
	
	@OneToMany(mappedBy="instrutor")
	@JsonIgnore
	private List<AvaliacaoFisica> avaliacaoFisica = new ArrayList<>();
	
	public Instrutor() {
		
	}

	public Instrutor(Long id, String cpf, String email, String genero, String login, String matricula, String nome,
			String senha, String rg, String telefone, Endereco endereco, TipoUsuario tipoUsuario) {
		super(id, cpf, email, genero, login, matricula, nome, senha, rg, telefone, endereco, tipoUsuario);
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<AvaliacaoFisica> getAvaliacaoFisica() {
		return avaliacaoFisica;
	}

	public void setAvaliacaoFisica(List<AvaliacaoFisica> avaliacaoFisica) {
		this.avaliacaoFisica = avaliacaoFisica;
	}
	
	
	
	
}