package com.rootfit.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class AvaliacaoFisica implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Float peso;
	private Float altura;
	private Float percMuscular;
	private Float imc;
	private Date data;
	
	@ManyToOne
	@JoinColumn(name="aluno_id")
	private Aluno aluno;
	
	@ManyToOne
	@JoinColumn(name="instrutor_id")
	private Instrutor avaliador;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="avaliacaoFisica")
	private GrupoMuscular grupomuscular;
	
	public AvaliacaoFisica() {
		
	}

	public AvaliacaoFisica(Long id, Float peso, Float altura, Float percMuscular, Float imc, Date data,
			GrupoMuscular grupomuscular) {
		super();
		this.id = id;
		this.peso = peso;
		this.altura = altura;
		this.percMuscular = percMuscular;
		this.imc = imc;
		this.data = data;
		this.grupomuscular = grupomuscular;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getPeso() {
		return peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

	public Float getAltura() {
		return altura;
	}

	public void setAltura(Float altura) {
		this.altura = altura;
	}

	public Float getPercMuscular() {
		return percMuscular;
	}

	public void setPercMuscular(Float percMuscular) {
		this.percMuscular = percMuscular;
	}

	public Float getImc() {
		return imc;
	}

	public void setImc(Float imc) {
		this.imc = imc;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public GrupoMuscular getGrupomuscular() {
		return grupomuscular;
	}

	public void setGrupomuscular(GrupoMuscular grupomuscular) {
		this.grupomuscular = grupomuscular;
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
		AvaliacaoFisica other = (AvaliacaoFisica) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
