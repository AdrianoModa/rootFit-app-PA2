package com.rootfit.model.enums;

public enum Rules {
	
	ADMINISTRADOR(1, "Administrador"),
	FUNCIONARIO(2, "Funcionário");
	
	private int cod;
	private String descricao;
	
	private Rules(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static Rules toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (Rules rule : Rules.values()) {
			if (cod.equals(rule.getCod())){
				return rule;	
			}
		}
		
		throw new IllegalArgumentException("Id inválido " + cod);
		
	}
	
	

}
