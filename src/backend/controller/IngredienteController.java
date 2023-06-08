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

	private static final long serialVersionUID = 1L;
	private static ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
	private static int ingCount = 0;
	
	public IngredienteController() {
		
		ingredientes = new ArrayList<Ingrediente>();
		IngredienteController.carregarIngredientes();
		
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
			salvarIngredientes(ingredientes);
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
		salvarIngredientes(ingredientes);
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

	public static void salvarIngredientes(ArrayList<Ingrediente> pratos) {
		try {
			FileOutputStream fileOut = new FileOutputStream("ingredientes_serializados.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);

			out.writeObject(pratos);

			out.close();
			fileOut.close();
			System.out.println("Os ingredientes foram salvos com sucesso.");
		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao escrever no arquivo: " + e);
		}

	}

	public static void carregarIngredientes() {

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
			System.out.println("Ocorreu um erro ao desserializar o arquivo: " + e);
		}
	}
}
