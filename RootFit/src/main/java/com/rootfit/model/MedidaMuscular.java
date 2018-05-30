package com.rootfit.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class MedidaMuscular {
	
	@Id
	private Long id;
	private String nome;
	private Double tamanho;
	
	@ManyToMany(mappedBy= "medidasMusculares")
	@JsonIgnore
	private List<AvaliacaoFisica> avaliacoesFisicas = new ArrayList<>();
	
	public MedidaMuscular() {
		
	}

	public MedidaMuscular(Long id, String nome, Double tamanho) {
		super();
		this.id = id;
		this.nome = nome;
		this.tamanho = tamanho;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getTamanho() {
		return tamanho;
	}

	public void setTamanho(Double tamanho) {
		this.tamanho = tamanho;
	}

	public List<AvaliacaoFisica> getAvaliacoesFisicas() {
		return avaliacoesFisicas;
	}

	public void setAvaliacoesFisicas(List<AvaliacaoFisica> avaliacoesFisicas) {
		this.avaliacoesFisicas = avaliacoesFisicas;
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
		MedidaMuscular other = (MedidaMuscular) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

}
