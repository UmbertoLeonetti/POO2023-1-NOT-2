package backend;

import java.io.Serializable;

import backend.controller.Controller;
import backend.model.Ingrediente;
import backend.model.Prato;

public class Restaurante implements Serializable {
	private static final long serialVersionUID = 1L;
	public Controller<Ingrediente>	ingredientes;
	public Controller<Prato>	 	pratos;
	
	public Restaurante() {
		ingredientes	= new Controller<Ingrediente>();
		pratos 			= new Controller<Prato>();
	}
}
