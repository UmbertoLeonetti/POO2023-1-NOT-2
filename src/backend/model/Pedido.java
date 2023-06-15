package backend.model;

import backend.controller.Controller;

public class Pedido implements Item {
	
	private Controller<Produto> produtos;
	private String nomeCliente;

	public Pedido(String nomeCliente) {
		this.nomeCliente = nomeCliente;
		produtos = new Controller<Produto>();
	}
	
	public Controller<Produto> getProdutos(){
		return produtos;
	}

	@Override
	public String getNome() {
		return nomeCliente;
	}
}
