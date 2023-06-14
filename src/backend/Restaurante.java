package backend;

import java.io.Serializable;

import backend.controller.Controller;
import backend.model.Cardapio;
import backend.model.Ingrediente;
import backend.model.Prato;
import backend.model.Reserva;

public class Restaurante implements Serializable {
	private static final long serialVersionUID = 1L;
	public Controller<Ingrediente>	ingredientes;
	public Controller<Prato>	 	pratos;
<<<<<<< Updated upstream
	public Controller<Cardapio>	 	cardapios;
	public Controller<Reserva>		reservas;
=======
	public Controller<Reserva>	 	reserva;
>>>>>>> Stashed changes
	
	public Restaurante() {
		ingredientes	= new Controller<Ingrediente>();
		pratos 			= new Controller<Prato>();
		reserva 		= new Controller<Reserva>();
	}
}
