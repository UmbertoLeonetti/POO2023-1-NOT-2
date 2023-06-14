package backend.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reserva implements Item {

	private LocalDate data;
	private LocalTime horario;
	private String nomeCliente;
	private LocalDate dataAtual;
    private LocalTime horaAtual;

	public Reserva(String nomeCliente,LocalDate data, LocalTime horario) {
		setNomeCliente(nomeCliente);
		setDataHorario(data, horario);
		this.dataAtual = LocalDate.now();
        this.horaAtual = LocalTime.now();
	}

	public void setDataHorario(LocalDate data, LocalTime horario) {
		LocalDate hoje = LocalDate.now();
		if (data.isBefore(hoje))
			throw new IllegalArgumentException("Data não pode ser anterior.");

		if (data.isEqual(hoje) && horario.isBefore(LocalTime.now()))
			throw new IllegalArgumentException("Horário não pode ser anterior.");

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
	
	

	public LocalDate getDataAtual() {
		return dataAtual;
	}

	public void setDataAtual(LocalDate dataAtual) {
		this.dataAtual = dataAtual;
	}

	public LocalTime getHoraAtual() {
		return horaAtual;
	}

	public void setHoraAtual(LocalTime horaAtual) {
		this.horaAtual = horaAtual;
	}

	@Override
	public String getNome() {
		return nomeCliente;
	}

}
