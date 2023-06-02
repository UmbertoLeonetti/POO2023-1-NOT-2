package backend.controller;

import java.util.ArrayList;

import backend.model.Ingrediente;

public class IngredienteController {
	private ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
	private static int ingCount = 0;
	
	public Ingrediente get(int index) {
		return ingredientes.get(index);
	}
	
	public Ingrediente get(String nome) {
		for (Ingrediente ingrediente : ingredientes) {
			if(ingrediente.toString() == nome)
				return ingrediente;
		}
		
		return null;
	}
	
	public void add(Ingrediente ing) throws IllegalArgumentException {		
		if(get(ing.toString()) == null)
			ingredientes.add(ing);
		else
			throw new IllegalArgumentException("Ingrediente com nome '" + ing + "' já existe");
	}
	
	public ArrayList<String> getNomes() {
		ArrayList<String> str = new ArrayList<String>();
		
		for (Ingrediente ingrediente : ingredientes) 
			str.add(ingrediente.toString());
		
		return str;
	}
	
	public String[] getNomesArray() {
		return getNomes().toArray(new String[getNomes().size()]);
	}
	
	public void add() {		
		ingCount++;
		add(new Ingrediente("Ingrediente " + ingCount));
	}
	
	public void remove(Ingrediente ing) {
		ingredientes.remove(ing);
	}
	
	public void remove(int index) {
		ingredientes.remove(index);
	}
	
	public void remove(String nome) {
		remove(get(nome));
	}
}
