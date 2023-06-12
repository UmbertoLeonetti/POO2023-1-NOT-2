package backend.model;

import backend.controller.Controller;

public class Pedido extends Reserva {
	
	private Controller<Produto> produtos;

	public Pedido(String nomeCliente) {
		super(nomeCliente);
		produtos = new Controller<Produto>();
	}
	
	public Controller<Produto> getProdutos(){
		return produtos;
	}
}
