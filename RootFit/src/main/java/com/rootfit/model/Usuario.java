package com.rootfit.model;


import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String cpf;
	private String email;
	private String genero;
	private String login;
	private String matricula;
	private String nome;
	private String senha;
	private String rg;
	private String telefone;

	
	@ManyToOne
	@JoinColumn(name="endereco_id")
	private Endereco endereco;
	
	@JsonBackReference
	@ManyToMany(fetch= FetchType.EAGER)
	@JoinTable(name="usuario_permissao", joinColumns = @JoinColumn(name="usuario_id"),
				inverseJoinColumns = @JoinColumn(name="permissao_id"))
	private List<Permissao> permissoes;
	
	public Usuario() {
		
	}
	
	public Usuario(Long id) {
		this.id = id;
	}

	public Usuario(Long id, String cpf, String email, String genero, String login, String matricula, String nome,
			String senha, String rg, String telefone, Endereco endereco) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.email = email;
		this.genero = genero;
		this.login = login;
		this.matricula = matricula;
		this.nome = nome;
		this.senha = senha;
		this.rg = rg;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	
	 public List<Permissao> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(List<Permissao> permissoes) {
		this.permissoes = permissoes;
	}

	@Override
	    public int hashCode() {

	        return Objects.hash(id);
	    }
	 
	 @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof Usuario)) return false;
	        Usuario usuario = (Usuario) o;
	        return Objects.equals(id, usuario.id);
	    }

	   
}
