package com.project.oficina;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.project.oficina.enums.Servicos;
import com.project.oficina.enums.ValoresServico;
import com.project.oficina.models.Carro;
import com.project.oficina.models.Oficina;
import com.project.oficina.repository.CarroRepository;

@SpringBootApplication
public class OficinaApplication {

	public static void main(String[] args) {
		SpringApplication.run(OficinaApplication.class, args);
	}
	
	private CarroRepository carroRepository;
	private Servicos servicos;
	private ValoresServico valServicos;
	
	
	public OficinaApplication(CarroRepository carroRepository, ValoresServico valServicos, Servicos servicos) {
		super();
		this.carroRepository = carroRepository;
		this.servicos = servicos;
		this.valServicos = valServicos;
	}

	public void runproject() {
		try (Scanner leitor = new Scanner(System.in)) {
			Carro carro = new Carro();
			Oficina oficinaCarro = new Oficina();
			List<Carro> carros = new ArrayList<Carro>();
			List<Oficina> oficina = new ArrayList<Oficina>(30);

			System.out.println("Entrada do carro:" + "\nDigite a marca:");
			carro.setMarca(leitor.next());
			System.out.println("Digite a placa:");
			carro.setPlaca(leitor.next());
			System.out.println("Digite o modelo:");
			carro.setModelo(leitor.next());

			System.out.println("Escolha o serviço:" 
					+ servicos.getDescricao() + "\nValores dos serviços: "
					+ valServicos.getValores());
			carroRepository.save(carro);

			oficinaCarro.getCarro().add(carro);
			oficina.add(oficinaCarro);
			carros.add(carro);

			System.out.println("Carros na oficina atualmente: " + carros);
			System.out.println("Quantidade de vagas: " + getCapacity(oficina));
		} catch (Exception e) {
			System.out.println("erro");
		}

	}

	static int getCapacity(List al) throws Exception {
		Field field = ArrayList.class.getDeclaredField("elementData");
		field.setAccessible(true);
		return ((Object[]) field.get(al)).length;
	}


}
