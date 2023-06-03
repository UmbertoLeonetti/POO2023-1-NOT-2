package backend;

import java.util.ArrayList;

public class Produto {
	
	private ArrayList<Ingrediente> ingredientes;
	private String nome;
	
	public Produto(String nome) {
		
		setNome(nome);
		ingredientes = new ArrayList<Ingrediente>();
		
	}

	public void addIngrediente(Ingrediente ingrediente) {
		
		
		if(ingredientes.contains(ingrediente)) {
			
			throw new IllegalArgumentException("Esse ingrediente já está adicionado ao Produto.");
			
		}
		
		ingredientes.add(ingrediente);
		
	}
	
	public boolean removeIngrediente(Ingrediente ingrediente) {
		
		return ingredientes.remove(ingrediente);
		
	}
	
	public Ingrediente getIngrediente(String nome) {
		
		for (Ingrediente ingrediente : ingredientes) {
			
			if (nome.equals(ingrediente.getNome())) {
				
				return ingrediente;
				
			}
			
		}
		
		return null;
		
	}
	
	public void setNome(String nome) {
		
		if (nome.length() <= 0) {
			
			throw new IllegalArgumentException("Nome deve ter pelo menos um caracter.");
			
		}
		
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
}
