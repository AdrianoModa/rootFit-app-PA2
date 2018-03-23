package com.rootfit.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Empresa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nome;
	private String razaoSocial;
	private String cnpj;
	// TODO private Endereco endereco;
	private String horarioFuncionamento; //TODO Verificar outro tipo de atributo (Calendar, ou date..)
	private Boolean matriz_filial;
	
	@OneToMany(mappedBy="empresa")
	private List<Aluno> alunos = new ArrayList<>();
	//TODO private List<Colaborador> colaboradores = new ArrayList<>();
	@OneToMany(mappedBy="empresa")
	private List<Instrutor> instrutores = new ArrayList<>();
	
	public Empresa() {
		
	}
	
	
	public Empresa(Long id, String nome, String razaoSocial, String cnpj, String horarioFuncionamento,
			Boolean matriz_filial) {
		super();
		this.id = id;
		this.nome = nome;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.horarioFuncionamento = horarioFuncionamento;
		this.matriz_filial = matriz_filial;
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
	
	public String getRazaoSocial() {
		return razaoSocial;
	}
	
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getHorarioFuncionamento() {
		return horarioFuncionamento;
	}
	
	public void setHorarioFuncionamento(String horarioFuncionamento) {
		this.horarioFuncionamento = horarioFuncionamento;
	}
	
	public Boolean getMatriz_filial() {
		return matriz_filial;
	}
	
	public void setMatriz_filial(Boolean matriz_filial) {
		this.matriz_filial = matriz_filial;
	}
	
	public List<Aluno> getAlunos() {
		return alunos;
	}
	
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	public List<Instrutor> getInstrutores() {
		return instrutores;
	}
	
	public void setInstrutores(List<Instrutor> instrutores) {
		this.instrutores = instrutores;
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
		Empresa other = (Empresa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

}
