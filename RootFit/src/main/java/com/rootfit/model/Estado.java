package com.rootfit.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class Estado implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;

	private Long CodigoUf;
	private String Nome;
	private String Uf;
	private String Regiao;
	
	@OneToMany(mappedBy="estado", cascade=CascadeType.ALL)
	private List<Cidade> cidades = new ArrayList<>();
	
	public Estado() {
		
	}

	public Estado(Long codigoUf, String nome, String uf, String regiao, List<Cidade> cidades) {
		CodigoUf = codigoUf;
		Nome = nome;
		Uf = uf;
		Regiao = regiao;
		this.cidades = cidades;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Long getCodigoUf() {
		return CodigoUf;
	}

	public void setCodigoUf(Long codigoUf) {
		CodigoUf = codigoUf;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getUf() {
		return Uf;
	}

	public void setUf(String uf) {
		Uf = uf;
	}

	public String getRegiao() {
		return Regiao;
	}

	public void setRegiao(String regiao) {
		Regiao = regiao;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Estado)) return false;
		Estado estado = (Estado) o;
		return Objects.equals(Id, estado.Id) &&
				Objects.equals(CodigoUf, estado.CodigoUf) &&
				Objects.equals(Nome, estado.Nome) &&
				Objects.equals(Uf, estado.Uf) &&
				Objects.equals(Regiao, estado.Regiao) &&
				Objects.equals(cidades, estado.cidades);
	}

	@Override
	public int hashCode() {

		return Objects.hash(Id, CodigoUf, Nome, Uf, Regiao, cidades);
	}
}
