package backend.model;

import java.util.ArrayList;

public class Pedido {
	private String mesa;
	
	private ArrayList<Produto> produtos = new ArrayList<Produto>();
	
	public Pedido(String mesa) {
		setMesa(mesa);
	}
	
	public String getMesa() {
		return mesa;
	}

	public void setMesa(String mesa) {
		this.mesa = mesa;		
	}
	
	public void addIngrediente(Produto p) {
		produtos.add(p);
	}
	
	public void removeIngrediente(Produto p) {
		produtos.remove(p);
	}
}
