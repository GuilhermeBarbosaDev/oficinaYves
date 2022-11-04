package com.project.oficina.enums;

public enum ValoresServico {

	V_MANUNTENCAO("R$: 00.00"),
	V_TROCAPNEU("R$: 00.00"),
	V_TROCAOLEO("R$: 00.00"),
	V_ALINHAMENTO("R$: 00.00"),
	V_REVISAO("R$: 00.00");

	private String valores;

	ValoresServico(String valores){
		this.valores = valores;
	}
	
	public String getValores() {
		return valores;
	}
}
