package backend.controller;

import java.io.Serializable;
import java.util.ArrayList;

import backend.model.Ingrediente;

public class IngredienteController implements Serializable {

	private static final long serialVersionUID = -3702407357918579454L;
	private ArrayList<Ingrediente> ingredientes;
	private int ingCount = 0;
	
	public IngredienteController() {
		ingredientes = new ArrayList<Ingrediente>();		
	}

	public Ingrediente get(int index) {
		return ingredientes.get(index);
	}

	public Ingrediente get(String nome) {
		if(nome == null)
			return null;
		
		for (Ingrediente ingrediente : ingredientes) {
			if (ingrediente.getNome().compareTo(nome) == 0)
				return ingrediente;
		}

		return null;
	}

	public void add(Ingrediente ing) throws IllegalArgumentException {
		if (get(ing.getNome()) == null)
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
	
	public String getListaIngredientes() {
        StringBuilder sb = new StringBuilder();

        for (Ingrediente ing : ingredientes) {
            sb.append(ing.toString()).append("\n");
        }

        return sb.toString();
    }
}
