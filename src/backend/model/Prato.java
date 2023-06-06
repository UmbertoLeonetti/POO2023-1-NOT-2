package backend.model;

import java.io.Serializable;

import backend.controller.IngredienteController;

public class Prato extends Produto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1438057443229834943L;
	private double quilo;
	
	public Prato() {
		super();
	}
	
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
		return "Prato [getNome()=" + getNome() + ", getValor()=" + getValor() + ", getIngredientes()="
				+ getIngredientes() + ", quilo=" + quilo + "]";
	}

	
}
