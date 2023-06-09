package backend.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import backend.model.Ingrediente;
import backend.model.Prato;

public class IngredienteController implements Serializable {
	
	private static final long serialVersionUID = 4517401700842185348L;
	private ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
	private int ingCount = 0;
	private boolean serializar = true;
	
	public void deveSerializar(boolean serializar) {
		this.serializar = serializar;
	}
	
	public IngredienteController(boolean serializar) {
		ingredientes = new ArrayList<Ingrediente>();
		deveSerializar(serializar);
		carregarIngredientes();
	}

	public Ingrediente get(int index) {
		return ingredientes.get(index);
	}

	public Ingrediente get(String nome) {
		for (Ingrediente ingrediente : ingredientes) {
			if (ingrediente.getNome() == nome)
				return ingrediente;
		}

		return null;
	}

	public void add(Ingrediente ing) throws IllegalArgumentException {
		if (get(ing.getNome()) == null) {
			ingredientes.add(ing);
			salvarIngredientes();
		} else {
			throw new IllegalArgumentException("Ingrediente com nome '" + ing.getNome() + "' já existe");
		}

	}

	public ArrayList<String> getNomes() {
		ArrayList<String> str = new ArrayList<String>();

		for (Ingrediente ingrediente : ingredientes)
			str.add(ingrediente.getNome());

		return str;
	}

	public void add(Ingrediente ing, int index) {
		ingredientes.add(index, ing);
		salvarIngredientes();
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
		salvarIngredientes();
	}

	public void remove(int index) {
		ingredientes.remove(index);
		salvarIngredientes();
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

	public void salvarIngredientes() {
		if(!serializar)
			return;
		
		try {
			FileOutputStream fileOut = new FileOutputStream("ingredientes_serializados.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);

			out.writeObject(ingredientes);

			out.close();
			fileOut.close();
			System.out.println("Os ingredientes foram salvos com sucesso.");
			
		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao escrever no arquivo: " + e);
		}

	}

	public void carregarIngredientes() {
		if(!serializar)
			return;
		
		File arquivo = new File("ingredientes_serializados.txt");

		if (!arquivo.exists()) {
			return;
		}

		try {
			FileInputStream fileIn = new FileInputStream(arquivo);
			ObjectInputStream in = new ObjectInputStream(fileIn);

			Object obj = in.readObject();
			if (obj instanceof ArrayList) {
				ingredientes = ((ArrayList<Ingrediente>) obj);
				System.out.println("Os ingredientes foram carregados com sucesso.");
				
			} else {
				System.out.println("O arquivo não pode ser aberto.");
			}

			in.close();
			fileIn.close();

		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Ocorreu um erro ao desserializar o arquivo: ");
			e.printStackTrace();
		}
	}
}
