package com.rootfit.model.enums;

public enum TipoColaborador {
	
	ADMINISTRADOR(1, "Administrador"),
	FUNCIONARIO(2, "Funcionário"),
	PROPRIETARIO(3, "Dono");
	
	private int cod;
	private String descricao;
	
	private TipoColaborador(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static TipoColaborador toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (TipoColaborador rule : TipoColaborador.values()) {
			if (cod.equals(rule.getCod())){
				return rule;	
			}
		}
		
		throw new IllegalArgumentException("Id inválido " + cod);
		
	}
	
	

}
