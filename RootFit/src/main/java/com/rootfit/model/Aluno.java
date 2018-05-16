package com.rootfit.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Aluno extends Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	private Boolean status;
	private String objetivo;
	private Date nascimento;
	private Date inicio;
	
	@ManyToOne
	@JoinColumn(name="instrutor_id")
	private Instrutor instrutor;
	
	@OneToMany(mappedBy="aluno")
	private List<AvaliacaoFisica> avaliacoesFisicas = new ArrayList<>();

	@OneToMany(mappedBy="aluno")
	private List<FichaTreino> fichasTreino = new ArrayList<>();
	
	@ManyToOne
	private Endereco endereco;
	
	public Aluno() {
		
	}
	
	public Aluno(Long id) {
		super(id);
		
	}
	
	public Aluno(Long id, Boolean status, String objetivo, Date nascimento, Date inicio, Instrutor instrutor) {
		super(id);
		this.status = status;
		this.objetivo = objetivo;
		this.nascimento = nascimento;
		this.inicio = inicio;
		this.instrutor = instrutor;
	}

	@ManyToOne
	@JoinColumn(name = "endereco_id")
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Instrutor getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
	}

	public void setAvaliacoesFisicas(List<AvaliacaoFisica> avaliacoesFisicas) {
		this.avaliacoesFisicas = avaliacoesFisicas;
	}

	public List<FichaTreino> getFichasTreino() {
		return fichasTreino;
	}

	public void setFichasTreino(List<FichaTreino> fichasTreino) {
		this.fichasTreino = fichasTreino;
	}

	public Date getInicio() {
		return inicio;
	}

	public List<AvaliacaoFisica> getAvaliacoesFisicas() {
		return avaliacoesFisicas;
	}
	
	
}