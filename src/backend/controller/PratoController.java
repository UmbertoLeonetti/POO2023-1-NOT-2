package backend.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import backend.model.Prato;

public class PratoController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7414305687116640292L;

	private static ArrayList<Prato> pratos;
	private static int prodCount = 0;

	public PratoController() {
		pratos = new ArrayList<Prato>();
		PratoController.carregarPratos();

	}

	public void add() {
		prodCount++;
		pratos.add(new Prato("Prato " + prodCount));
		salvarPratos(pratos);
	}

	public void add(Prato produto) throws IllegalArgumentException {
		if (get(produto.toString()) == null)
			pratos.add(produto);
		else
			throw new IllegalArgumentException("Prato com nome '" + produto.getNome() + "' já existe");
	}

	public ArrayList<String> getNomes() {
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
			if (prato.getNome() == nome)
				return prato;

		return null;
	}
	
	public String getListaPratos() {
        StringBuilder sb = new StringBuilder();

        for (Prato prato : pratos) {
            sb.append(prato.toString()).append("\n");
        }

        return sb.toString();
    }

	public static void salvarPratos(ArrayList<Prato> pratos) {
		try {
			FileOutputStream fileOut = new FileOutputStream("pratos_serializados.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);

			out.writeObject(pratos);

			out.close();
			fileOut.close();
			System.out.println("Pratos foram salvos com sucesso.");
		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao escrever no arquivo: " + e);
		}

	}

	public static void carregarPratos() {
		
		 File arquivo = new File("pratos_serializados.txt");

		    if (!arquivo.exists()) {
		        return;
		    }

		try {
			FileInputStream fileIn = new FileInputStream(arquivo);
			ObjectInputStream in = new ObjectInputStream(fileIn);

			Object obj = in.readObject();
			if (obj instanceof ArrayList) {
				
				pratos = ((ArrayList<Prato>) obj);
				
				System.out.println("Os pratos foram carregados com sucesso.");
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
