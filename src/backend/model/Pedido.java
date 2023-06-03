package backend.model;

import java.util.ArrayList;

public class Pedido {
	
	private String nomeCliente;
	private int mesa;

	private ArrayList<Produto> produtos;

	public Pedido(String nomeCliente, int mesa) {
		setNome(nomeCliente);
		setMesa(mesa);
		produtos = new ArrayList<Produto>();
	}

	public void setNome(String nome) {
		if (nome.length() < 4)
			throw new IllegalArgumentException("Nome de cliente deve conter 4 caracteres.");

		this.nomeCliente = nome;
	}
	
	public void setMesa(int mesa) {
		
		if (mesa < 1 || mesa > 25) {
			
			throw new IllegalArgumentException("Valor de mesa deve ser de 1 a 25.");
			
		}
		
		this.mesa = mesa;
	}

	public String getNome() {
		return nomeCliente;
	}
	
	public int getMesa() {
		return mesa;
	}

	public void addProduto(Produto p) {
		produtos.add(p);
	}

	public boolean removeProduto(Produto p) {
		return produtos.remove(p);
	}
}
