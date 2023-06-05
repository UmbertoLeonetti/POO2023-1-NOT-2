package backend.model;

import java.util.ArrayList;

import backend.controller.IngredienteController;

public class Produto {
	private String nome;
	private String desc;
	private double valor;
	private IngredienteController ingredientes;
	
	public String toString() {
		return null;
	}
	
	public Produto(String nome) {
		setNome(nome);
		ingredientes = new IngredienteController();
		desc = "";
		valor = 0.00f;
	}
	
	public Produto(String nome, String desc, double valor, IngredienteController ingredientes) {
		setNome(nome);
		setDesc(desc);
		setValor(valor);
		setIngredientes(ingredientes);
	}
	
	public double calculaValor() {
		return valor;
	}
	
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public IngredienteController getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(IngredienteController ingredientes) {
		this.ingredientes = ingredientes;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;		
	}
	
	public void addIngrediente(Ingrediente i) {
		ingredientes.add(i);
	}
	
	public void removeIngrediente(Ingrediente i) {
		ingredientes.remove(i);
	}
}
