package backend.model;

import java.time.LocalDateTime;

import backend.controller.Controller;

public class Pedido implements Item {
	
	private String nomeCliente;
	private int mesa;
	LocalDateTime dataHorario;
	private Controller<Produto> produtos;

	public Pedido(String nomeCliente, int mesa) {
		setNome(nomeCliente);
		setMesa(mesa);
		produtos = new Controller<Produto>();
		this.dataHorario = LocalDateTime.now();
	}
	
	public Controller<Produto> getProdutos(){
		return produtos;
	}
	

	@Override
	public String getNome() {
		return nomeCliente;
	}
	
	@Override
	public void setNome(String nome) {
		this.nomeCliente = nome;
	}
	
	public int getMesa() {
		return mesa;
	}

	public void setMesa(int mesa) {
		if (mesa <= 0) {
			throw new IllegalArgumentException("Número de mesa deve ser positivo");
		}
		this.mesa = mesa;
	}

	public LocalDateTime getDataHorario() {
		return dataHorario;
	}

	public void setDataHorario(LocalDateTime dataHorario) {
		this.dataHorario = dataHorario;
	}

	public void setProdutos(Controller<Produto> produtos) {
		this.produtos = produtos;
	}


	@Override
	public String getClassName() {
		return "Pedido";
	}
	
	
}
