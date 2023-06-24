package backend.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import backend.controller.Controller;

public class Reserva implements Item {

	private String nomeCliente;
	private int mesa;
	private LocalDateTime dataHorario;

	private Controller<Produto> produtos;
	
	public Controller<Produto> getProdutos(){
		return produtos;
	}
	
	public Reserva() {
		produtos = new Controller<Produto>();
		setNome("");
		dataHorario = LocalDateTime.now();
	}
    
    public Reserva(String nomeCliente) {
    	produtos = new Controller<Produto>();
    	setNome(nomeCliente);
		dataHorario = LocalDateTime.now();
    }


	public Reserva(String nomeCliente, LocalDateTime dataHorario) {
    	produtos = new Controller<Produto>();
		setNome(nomeCliente);
		setDataHorario(dataHorario);
	}
	
	public Reserva(String nomeCliente, LocalDate data, LocalTime horario) {
		produtos = new Controller<Produto>();
		setNome(nomeCliente);
		setDataHorario(dataHorario);
	}

	public void setDataHorario(LocalDateTime dataHorario) throws IllegalArgumentException {
		
		if (dataHorario.isBefore(LocalDateTime.now().withSecond(0).withNano(0)))
			throw new IllegalArgumentException("Data ou horário não podem ser anteriores.");
		
		this.dataHorario = dataHorario;
		
	}
	
	public void setDataHorario(LocalDate data, LocalTime horario) {
		
		LocalDateTime dataHorario = LocalDateTime.of(data, horario);
		
		if (dataHorario.isBefore(LocalDateTime.now().withSecond(0).withNano(0)))
			throw new IllegalArgumentException("Data ou horário não podem ser anteriores.");
		
		this.dataHorario = dataHorario;
		
	}

	public LocalDate getData() {
		return dataHorario.toLocalDate();
	}

	public LocalTime getHorario() {
		return dataHorario.toLocalTime();
	}
	
	public LocalDateTime getDataHorario() {
		return dataHorario;
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
	
	public int getMesa() {
		return mesa;
	}
	
	public void setMesa(int mesa) {
		this.mesa = mesa;
	}
	
}
