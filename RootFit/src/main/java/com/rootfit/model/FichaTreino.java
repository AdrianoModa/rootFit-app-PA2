package com.rootfit.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class FichaTreino implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	private Date instance;
	
	@OneToOne
	@JoinColumn(name="aluno_id")
	@MapsId
	private Aluno aluno;
	
	@OneToOne
	@JoinColumn(name="instrutor_id")
	@MapsId
	private Instrutor instrutor;
	
	
	private List<Exercicio> exercicios = new ArrayList<Exercicio>();
	
	public FichaTreino() {
		
	}

	public FichaTreino(Long id, Date instance, Aluno aluno, Instrutor instrutor) {
		super();
		this.id = id;
		this.instance = instance;
		this.aluno = aluno;
		this.instrutor = instrutor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getInstance() {
		return instance;
	}

	public void setInstance(Date instance) {
		this.instance = instance;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Instrutor getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
	}

	public List<Exercicio> getExercicios() {
		return exercicios;
	}

	public void setExercicios(List<Exercicio> exercicios) {
		this.exercicios = exercicios;
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
		FichaTreino other = (FichaTreino) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
