package backend.model;

import backend.controller.IngredienteController;

public class Prato extends Produto {
	private double quilo;
	
	public Prato(String nome) {
		super(nome);
		quilo = 0.00f;
	}
	
	public Prato(String nome, String desc, double valor, double quilo, IngredienteController ingredientes) {
		super(nome, desc, valor, ingredientes);
		setQuilo(quilo);
	}

	public double getQuilo() {
		return quilo;
	}

	public void setQuilo(double quilo) {
		this.quilo = quilo;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
}
