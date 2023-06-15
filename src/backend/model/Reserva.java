package backend.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reserva implements Item {

	private LocalDate data;
	private LocalTime horario;
	private String nomeCliente;

	public Reserva(String nomeCliente,LocalDate data, LocalTime horario) {
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
	public String getNome() {
		return nomeCliente;
	}

}
