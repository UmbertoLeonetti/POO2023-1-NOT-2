package backend.model;

import java.util.ArrayList;

public class Pedido {
	
	private String nomeCliente;
	private int mesa;

	private ArrayList<Produto> produtos;

	public Pedido(String nomeCliente, int mesa) {
		setNome(nomeCliente);
		produtos = new ArrayList<Produto>();
	}

	public void setNome(String nome) {
		if (nome.length() < 4)
			throw new IllegalArgumentException("Nome de cliente muito curto.");

		this.nomeCliente = nome;
	}

	public String getNome() {
		return nomeCliente;
	}

	public void addProduto(Produto p) {
		produtos.add(p);
	}

	public boolean removeProduto(Produto p) {
		return produtos.remove(p);
	}
}
