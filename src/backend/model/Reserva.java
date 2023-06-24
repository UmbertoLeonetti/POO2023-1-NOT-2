package backend.model;

import java.time.LocalDate;
import java.time.LocalTime;

import backend.controller.Controller;

public class Reserva implements Item {

	private LocalDate data;
	private LocalTime horario;
	private String nomeCliente;

	private Controller<Produto> produtos;
	
	public Controller<Produto> getProdutos(){
		return produtos;
	}
    
    public Reserva(String nomeCliente) {
    	produtos = new Controller<Produto>();
    	setNomeCliente(nomeCliente);
		this.data = LocalDate.now();
        this.horario = LocalTime.now();
    }


	public Reserva(String nomeCliente,LocalDate data, LocalTime horario) {
    	produtos = new Controller<Produto>();
		setNomeCliente(nomeCliente);
		setDataHorario(data, horario);
	}

	public void setDataHorario(LocalDate data, LocalTime horario) throws IllegalArgumentException {
		LocalDate hoje = LocalDate.now();
		if (data.isBefore(hoje))
			throw new IllegalArgumentException("Data não pode ser anterior à data atual.");

		if (data.isEqual(hoje) && horario.isBefore(LocalTime.now()))
			throw new IllegalArgumentException("Horário não pode ser anterior ao horário atual.");

		this.data = data;
		this.horario = horario;
	}

	public LocalDate getData() {
		return data;
	}

	public LocalTime getHorario() {
		return horario;
	}
	
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	@Override
	public void setNome(String nome) {
		this.nomeCliente = nome;
	}

	@Override
	public String getNome() {
		return nomeCliente;
	}
	
	@Override
	public String toString() {
		
		return "Reserva [getNome()=" + getNome() + ", getData()=" + getData() + ", getHorario()="
		+ getHorario() + ", getProdutos()=" + getProdutos() + "]";
		//return nomeCliente + ", " + getData() + " às " + getHorario();
	}
	
	@Override
	public String getClassName() {
		return "Reserva";
	}
	
}
