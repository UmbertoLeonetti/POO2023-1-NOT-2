package backend.controller;

import java.io.Serializable;
import java.util.ArrayList;

import backend.model.Ingrediente;

public class IngredienteController implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
	private static int ingCount = 0;
	
	public Ingrediente get(int index) {
		return ingredientes.get(index);
	}
	
	public Ingrediente get(String nome) {
		for (Ingrediente ingrediente : ingredientes) {
			if(ingrediente.getNome() == nome)
				return ingrediente;
		}
		
		return null;
	}
	
	public void add(Ingrediente ing) throws IllegalArgumentException {		
		if(get(ing.getNome()) == null)
			ingredientes.add(ing);
		else
			throw new IllegalArgumentException("Ingrediente com nome '" + ing.getNome() + "' já existe");
	}
	
	public ArrayList<String> getNomes() {
		ArrayList<String> str = new ArrayList<String>();
		
		for (Ingrediente ingrediente : ingredientes) 
			str.add(ingrediente.getNome());
		
		return str;
	}
	
	public void add(Ingrediente ing, int index) {
		ingredientes.add(index, ing);
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
