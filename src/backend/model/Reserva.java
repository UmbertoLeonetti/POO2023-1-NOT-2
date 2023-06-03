package backend.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reserva extends Pedido {

	private LocalDate data;
	private LocalTime horario;
	
	public Reserva(String nome, int mesa, LocalDate data, LocalTime horario) {
		
		super(nome, mesa);
		
		setDataHorario(data, horario);
		
	}
	
	public void setDataHorario(LocalDate data, LocalTime horario) {
		
		LocalDate hoje = LocalDate.now();
		
		if (data.isBefore(hoje)) {
			
			throw new IllegalArgumentException("Data não pode ser anterior.");
			
		} 
		
		if (data.isEqual(hoje) && horario.isBefore(LocalTime.now())) {
			
			throw new IllegalArgumentException("Horário não pode ser anterior.");
			
		}
		
		this.data = data;
		this.horario = horario;
		
	} 
	
	public LocalDate getData() {
		return data;
	}
	
	public LocalTime getHorario() {
		return horario;
	}

}
