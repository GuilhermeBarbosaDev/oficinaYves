package com.project.oficina.enums;

public enum Servicos{

	MANUNTENCAO("Manuntenção"),
	TROCAPNEU("Troca de pneu"),
	TROCAOLEO("Troca de óleo"),
	ALINHAMENTO("Alinhamento e balanceamento de pneu"),
	REVISAO("Revisão");

	private String descricao;

	Servicos(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
