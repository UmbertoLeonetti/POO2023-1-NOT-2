package backend;

import backend.controller.IngredienteController;
import backend.controller.PratoController;

public class Restaurante {
	public IngredienteController	ingredientes;
	public PratoController 			pratos;
	
	public Restaurante() {
		ingredientes	= new IngredienteController(true);
		pratos 			= new PratoController();
	}
}
