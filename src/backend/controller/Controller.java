package backend.controller;

import java.io.Serializable;
import java.util.ArrayList;
import backend.model.Item;
import backend.model.Reserva;

public class Controller<T extends Item> implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<T> list;
	
	public Controller(){
		list = new ArrayList<T>();
	}
	
	public T get(int index) {
		return list.get(index);
	}
	
	public T get(String nome) {
		if(nome == null)
			return null;
		
		for (T obj : list) {
			if (obj.getNome().compareTo(nome) == 0)
				return obj;
		}

		return null;
	}
	
	public void add(T obj) throws IllegalArgumentException {
		
		if(get(obj.getNome()) == null || obj instanceof Reserva)
			list.add(obj);
		else
			throw new IllegalArgumentException("Item com nome '" + obj.getNome() + "' já existe");
	}
	
	public void add(T obj, int index) {
		if(get(obj.getNome()) == null)
			list.add(index, obj);
		else
			throw new IllegalArgumentException("Item com nome '" + obj.getNome() + "' já existe");
	}
	
	public ArrayList<String> getNomes(){
		ArrayList<String> str = new ArrayList<String>();

		for (T obj : list)
			str.add(obj.getNome());

		return str;
	}
	
	public String[] getNomesArray() {
		return getNomes().toArray(new String[getNomes().size()]);
	}
	
	public void remove(String nome) {
		list.remove(get(nome));
	}
	
	public void remove(int index) {
		list.remove(index);
	}
}
