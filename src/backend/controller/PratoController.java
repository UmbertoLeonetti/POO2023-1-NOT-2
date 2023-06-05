package backend.controller;

import java.util.ArrayList;
import backend.model.Prato;

public class PratoController {
	private ArrayList<Prato> pratos;
	private static int prodCount = 0;
	
	public PratoController() {
		pratos = new ArrayList<Prato>(); 
	}
	
	public void add() {
		prodCount++;
		pratos.add(new Prato("Prato " + prodCount));
	}
	
	public void add(Prato produto) throws IllegalArgumentException {
		if(get(produto.toString()) == null)
			pratos.add(produto);
		else
			throw new IllegalArgumentException("Prato com nome '" + produto.getNome() + "' já existe");
	}
	
	public ArrayList<String> getNomes(){
		ArrayList<String> nomes = new ArrayList<String>();
		for (Prato prato : pratos) 
			nomes.add(prato.getNome());
		
		return nomes;
	}
	
	public void remove(int index) {
		pratos.remove(index);
	}
	
	public void remove(Prato prato) {
		pratos.remove(prato);
	}
	
	public void remove(String nome) {
		remove(get(nome));
	}
	
	public Prato get(int index) {
		return pratos.get(index);
	}
	
	public Prato get(String nome) {
		for (Prato prato : pratos)
			if(prato.getNome() == nome)
				return prato;
		
		return null;
	}
}
