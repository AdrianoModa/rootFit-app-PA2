package com.rootfit.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class GrupoMuscular implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	private Float peitoral;
	private Float bicipesDireito;
	private Float bicipesEsquerdo;
	private Float tricipesDireito;
	private Float tricipesEsquerdo;
	private Float latissimoDorso;
	private Float deltoideLateralDireito;
	private Float deltoideLateralEsquerdo;
	private Float deltoidePosteriorDireito;
	private Float deltoidePosteriorEsquerdo;
	private Float panturrilhaDireta;
	private Float panturrilhaEsquerda;
	private Float posteriorCoxaDireito;
	private Float posteriorCoxaEsquerdo;
	private Float quadricepisDireito;
	private Float quadricepisEsquerdo;
	
	
	@OneToOne
	@JoinColumn(name="avaliação_id")
	@MapsId
	private AvaliacaoFisica avaliacaoFisica;
	
	public GrupoMuscular() {
		
	}

	public GrupoMuscular(Long id, Float peitoral, Float bicipesDireito, Float bicipesEsquerdo, Float tricipesDireito,
			Float tricipesEsquerdo, Float latissimoDorso, Float deltoideLateralDireito, Float deltoideLateralEsquerdo,
			Float deltoidePosteriorDireito, Float deltoidePosteriorEsquerdo, Float panturrilhaDireta,
			Float panturrilhaEsquerda, Float posteriorCoxaDireito, Float posteriorCoxaEsquerdo,
			Float quadricepisDireito, Float quadricepisEsquerdo, AvaliacaoFisica avaliacaoFisica) {
		super();
		this.id = id;
		this.peitoral = peitoral;
		this.bicipesDireito = bicipesDireito;
		this.bicipesEsquerdo = bicipesEsquerdo;
		this.tricipesDireito = tricipesDireito;
		this.tricipesEsquerdo = tricipesEsquerdo;
		this.latissimoDorso = latissimoDorso;
		this.deltoideLateralDireito = deltoideLateralDireito;
		this.deltoideLateralEsquerdo = deltoideLateralEsquerdo;
		this.deltoidePosteriorDireito = deltoidePosteriorDireito;
		this.deltoidePosteriorEsquerdo = deltoidePosteriorEsquerdo;
		this.panturrilhaDireta = panturrilhaDireta;
		this.panturrilhaEsquerda = panturrilhaEsquerda;
		this.posteriorCoxaDireito = posteriorCoxaDireito;
		this.posteriorCoxaEsquerdo = posteriorCoxaEsquerdo;
		this.quadricepisDireito = quadricepisDireito;
		this.quadricepisEsquerdo = quadricepisEsquerdo;
		this.avaliacaoFisica = avaliacaoFisica;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getPeitoral() {
		return peitoral;
	}

	public void setPeitoral(Float peitoral) {
		this.peitoral = peitoral;
	}

	public Float getBicipesDireito() {
		return bicipesDireito;
	}

	public void setBicipesDireito(Float bicipesDireito) {
		this.bicipesDireito = bicipesDireito;
	}

	public Float getBicipesEsquerdo() {
		return bicipesEsquerdo;
	}

	public void setBicipesEsquerdo(Float bicipesEsquerdo) {
		this.bicipesEsquerdo = bicipesEsquerdo;
	}

	public Float getTricipesDireito() {
		return tricipesDireito;
	}

	public void setTricipesDireito(Float tricipesDireito) {
		this.tricipesDireito = tricipesDireito;
	}

	public Float getTricipesEsquerdo() {
		return tricipesEsquerdo;
	}

	public void setTricipesEsquerdo(Float tricipesEsquerdo) {
		this.tricipesEsquerdo = tricipesEsquerdo;
	}

	public Float getLatissimoDorso() {
		return latissimoDorso;
	}

	public void setLatissimoDorso(Float latissimoDorso) {
		this.latissimoDorso = latissimoDorso;
	}

	public Float getDeltoideLateralDireito() {
		return deltoideLateralDireito;
	}

	public void setDeltoideLateralDireito(Float deltoideLateralDireito) {
		this.deltoideLateralDireito = deltoideLateralDireito;
	}

	public Float getDeltoideLateralEsquerdo() {
		return deltoideLateralEsquerdo;
	}

	public void setDeltoideLateralEsquerdo(Float deltoideLateralEsquerdo) {
		this.deltoideLateralEsquerdo = deltoideLateralEsquerdo;
	}

	public Float getDeltoidePosteriorDireito() {
		return deltoidePosteriorDireito;
	}

	public void setDeltoidePosteriorDireito(Float deltoidePosteriorDireito) {
		this.deltoidePosteriorDireito = deltoidePosteriorDireito;
	}

	public Float getDeltoidePosteriorEsquerdo() {
		return deltoidePosteriorEsquerdo;
	}

	public void setDeltoidePosteriorEsquerdo(Float deltoidePosteriorEsquerdo) {
		this.deltoidePosteriorEsquerdo = deltoidePosteriorEsquerdo;
	}

	public Float getPanturrilhaDireta() {
		return panturrilhaDireta;
	}

	public void setPanturrilhaDireta(Float panturrilhaDireta) {
		this.panturrilhaDireta = panturrilhaDireta;
	}

	public Float getPanturrilhaEsquerda() {
		return panturrilhaEsquerda;
	}

	public void setPanturrilhaEsquerda(Float panturrilhaEsquerda) {
		this.panturrilhaEsquerda = panturrilhaEsquerda;
	}

	public Float getPosteriorCoxaDireito() {
		return posteriorCoxaDireito;
	}

	public void setPosteriorCoxaDireito(Float posteriorCoxaDireito) {
		this.posteriorCoxaDireito = posteriorCoxaDireito;
	}

	public Float getPosteriorCoxaEsquerdo() {
		return posteriorCoxaEsquerdo;
	}

	public void setPosteriorCoxaEsquerdo(Float posteriorCoxaEsquerdo) {
		this.posteriorCoxaEsquerdo = posteriorCoxaEsquerdo;
	}

	public Float getQuadricepisDireito() {
		return quadricepisDireito;
	}

	public void setQuadricepisDireito(Float quadricepisDireito) {
		this.quadricepisDireito = quadricepisDireito;
	}

	public Float getQuadricepisEsquerdo() {
		return quadricepisEsquerdo;
	}

	public void setQuadricepisEsquerdo(Float quadricepisEsquerdo) {
		this.quadricepisEsquerdo = quadricepisEsquerdo;
	}

	public AvaliacaoFisica getAvaliacaoFisica() {
		return avaliacaoFisica;
	}

	public void setAvaliacaoFisica(AvaliacaoFisica avaliacaoFisica) {
		this.avaliacaoFisica = avaliacaoFisica;
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
		GrupoMuscular other = (GrupoMuscular) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	

}
