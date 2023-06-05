package backend.model;

import java.util.ArrayList;

public abstract class Produto {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
	protected String nome;
	protected String desc;
	protected double valor;
	protected ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
	
	public abstract String toString();
	
	public double calculaValor() {
		
		return valor;
		
	}
	
	public Produto(String nome, String desc, float valor) {
		setNome(nome);
		setDesc(desc);
		setValor(valor);
=======
=======
>>>>>>> parent of 8d3c113 (Montando tela de Pratos)
=======
>>>>>>> parent of 8d3c113 (Montando tela de Pratos)
=======
>>>>>>> parent of 8d3c113 (Montando tela de Pratos)
	private String nome;
	private String desc;
	private double valor;
	private ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
	
	public abstract String toString();
	public double calculaValor() {
		return valor;
	}
	
	public Produto(String nome) {
		setNome(nome);
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> parent of 8d3c113 (Montando tela de Pratos)
=======
>>>>>>> parent of 8d3c113 (Montando tela de Pratos)
=======
>>>>>>> parent of 8d3c113 (Montando tela de Pratos)
=======
>>>>>>> parent of 8d3c113 (Montando tela de Pratos)
	}
	
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		
		if (desc.length() == 0) {
			
			throw new IllegalArgumentException("Descrição de produto deve conter caracteres.");
			
		}
		
		this.desc = desc;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		
		if (valor <= 0) {
			
			throw new IllegalArgumentException("Valor de produto deve ser positivo.");
			
		}
		
		this.valor = valor;
	}

	public ArrayList<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		
		if (nome.length() == 0) {
			
			throw new IllegalArgumentException("Nome de produto deve conter caracteres.");
			
		}
		
		this.nome = nome;		
	}
	
	public void addIngrediente(Ingrediente i) {
		ingredientes.add(i);
	}
	
	public boolean removeIngrediente(Ingrediente i) {
		return ingredientes.remove(i);
	}
}
