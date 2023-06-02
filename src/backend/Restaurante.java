package backend;

import backend.controller.IngredienteController;

public class Restaurante {
	public IngredienteController ingredientes;
	
	public Restaurante() {
		ingredientes = new IngredienteController();
	}
}
