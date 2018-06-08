package com.rootfit.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class AvaliacaoFisica implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Double peso;
	private Double altura;
	private LocalDate dataAvaliacao;
	private Double bracoEsquerda;
	private Double bracoDireito;
	private Double pernaEsquerda;
	private Double pernaDireita;
	private Double abdomen;
	private Double peitoral; 

	@ManyToOne
	@JoinColumn(name="aluno_id")
	private Aluno aluno;
	
	@ManyToOne
	@JoinColumn(name="instrutor_id")
	private Instrutor instrutor;
	
	@ManyToMany
	@JoinTable(name="medida_avaliacao",
		joinColumns = @JoinColumn(name="avaliacaoFisica_id"),
		inverseJoinColumns = @JoinColumn(name="medidaMuscular_id"))
	private List<MedidaMuscular> medidasMusculares = new ArrayList<>();
	
	public AvaliacaoFisica() {
		
	}

	public AvaliacaoFisica(Long id, Double peso, Double altura, LocalDate dataAvaliacao, Double bracoEsquerda,
			Double bracoDireito, Double pernaEsquerda, Double pernaDireita, Double abdomen, Double peitoral,
			Aluno aluno, Instrutor instrutor, List<MedidaMuscular> medidasMusculares) {
		super();
		this.id = id;
		this.peso = peso;
		this.altura = altura;
		this.dataAvaliacao = dataAvaliacao;
		this.bracoEsquerda = bracoEsquerda;
		this.bracoDireito = bracoDireito;
		this.pernaEsquerda = pernaEsquerda;
		this.pernaDireita = pernaDireita;
		this.abdomen = abdomen;
		this.peitoral = peitoral;
		this.aluno = aluno;
		this.instrutor = instrutor;
		this.medidasMusculares = medidasMusculares;
	}

	public List<MedidaMuscular> getMedidasMusculares() {
		return medidasMusculares;
	}

	public void setMedidasMusculares(List<MedidaMuscular> medidasMusculares) {
		this.medidasMusculares = medidasMusculares;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public LocalDate getDataAvaliacao() {
		return dataAvaliacao;
	}

	public void setDataAvaliacao(LocalDate dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Double getBracoEsquerda() {
		return bracoEsquerda;
	}

	public void setBracoEsquerda(Double bracoEsquerda) {
		this.bracoEsquerda = bracoEsquerda;
	}

	public Double getBracoDireito() {
		return bracoDireito;
	}

	public void setBracoDireito(Double bracoDireito) {
		this.bracoDireito = bracoDireito;
	}

	public Double getPernaEsquerda() {
		return pernaEsquerda;
	}

	public void setPernaEsquerda(Double pernaEsquerda) {
		this.pernaEsquerda = pernaEsquerda;
	}

	public Double getPernaDireita() {
		return pernaDireita;
	}

	public void setPernaDireita(Double pernaDireita) {
		this.pernaDireita = pernaDireita;
	}

	public Double getAbdomen() {
		return abdomen;
	}

	public void setAbdomen(Double abdomen) {
		this.abdomen = abdomen;
	}

	public Double getPeitoral() {
		return peitoral;
	}

	public void setPeitoral(Double peitoral) {
		this.peitoral = peitoral;
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