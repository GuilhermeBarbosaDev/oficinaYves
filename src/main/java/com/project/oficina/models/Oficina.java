package com.project.oficina.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.ManyToMany;

import com.project.oficina.enums.Servicos;
import com.project.oficina.enums.ValoresServico;


public class Oficina{

	private Servicos servicos;
	private ValoresServico valores;
	@ManyToMany(mappedBy = "carros")
	private Set<Carro> carro = new HashSet<>();
	
	public Servicos getServicos() {
		return servicos;
	}
	public ValoresServico getValores() {
		return valores;
	}
	
	public Set<Carro> getCarro() {
		return carro;
	}
	public void setCarro(Set<Carro> carro) {
		this.carro = carro;
	}
	
	@Override
	public String toString() {
		return "Oficina [servicos=" + servicos + ", valores=" + valores + ", carro=" + carro + "]";
	}
	
}
