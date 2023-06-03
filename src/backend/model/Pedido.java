package backend.model;

import java.util.ArrayList;

public class Pedido {
	private String nome;

	private ArrayList<Produto> produtos;

	public Pedido(String mesa) {
		setNome(mesa);
		produtos = new ArrayList<Produto>();
	}

	public void setNome(String nome) {
		if (nome.length() < 4)
			throw new IllegalArgumentException("Nome de cliente muito curto.");

		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void addIngrediente(Produto p) {
		produtos.add(p);
	}

	public void removeIngrediente(Produto p) {
		produtos.remove(p);
	}
}
