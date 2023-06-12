package backend.model;

import java.io.Serializable;

import backend.controller.IngredienteController;

public class Prato extends Produto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1438057443229834943L;
	private double gramas;
	
	public Prato(String nome) {
		super(nome);
		gramas = 0.00f;
	}
	
	public Prato(String nome, String desc, double valor, double gramas) {
		super(nome, desc, valor);
		setGramas(gramas);
	}

	public double getGramas() {
		return gramas;
	}

	public void setGramas(double gramas) {
		this.gramas = gramas;
	}

	@Override
	public String toString() {
		return "Prato [getNome()=" + getNome() + ", getValor()=" + getValor() + ", getIngredientes()="
				+ getIngredientes() + ", gramas=" + gramas + "]";
	}

	
}
