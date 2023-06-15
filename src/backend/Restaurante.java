package backend;

import java.io.Serializable;

import backend.controller.Controller;
import backend.model.Cardapio;
import backend.model.Ingrediente;
import backend.model.Prato;
import backend.model.Reserva;

public class Restaurante implements Serializable {
	private static final long serialVersionUID = -9013641685562420877L;
	public Controller<Ingrediente>	ingredientes;
	public Controller<Prato>	 	pratos;
	public Controller<Cardapio>	 	cardapios;
	public Controller<Reserva>		reservas;
	
	public Restaurante() {
		ingredientes	= new Controller<Ingrediente>();
		pratos 			= new Controller<Prato>();
		reservas 		= new Controller<Reserva>();
	}
}
