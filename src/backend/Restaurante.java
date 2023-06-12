package backend;

import java.io.Serializable;

import backend.controller.IngredienteController;
import backend.controller.PratoController;

public class Restaurante implements Serializable {
	private static final long serialVersionUID = 1L;
	public IngredienteController	ingredientes;
	public PratoController 			pratos;
	
	public Restaurante() {
		ingredientes	= new IngredienteController();
		pratos 			= new PratoController();
	}
}
