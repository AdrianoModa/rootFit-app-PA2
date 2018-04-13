package com.rootfit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Exercicio {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String descricao;
	private Integer serie;
	private Integer repeticao;
	
	@ManyToOne
	@JoinColumn(name="fichaTreino_id")
	private FichaTreino fichaTreino;
	
	public Exercicio() {
		
	}

	public Exercicio(Long id, String descricao, Integer serie, Integer repeticao, FichaTreino fichaTreino) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.serie = serie;
		this.repeticao = repeticao;
		this.fichaTreino = fichaTreino;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getSerie() {
		return serie;
	}

	public void setSerie(Integer serie) {
		this.serie = serie;
	}

	public Integer getRepeticao() {
		return repeticao;
	}

	public void setRepeticao(Integer repeticao) {
		this.repeticao = repeticao;
	}

	public FichaTreino getFichaTreino() {
		return fichaTreino;
	}

	public void setFichaTreino(FichaTreino fichaTreino) {
		this.fichaTreino = fichaTreino;
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
		Exercicio other = (Exercicio) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
