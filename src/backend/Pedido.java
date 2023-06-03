package backend;

import java.time.LocalTime;

public class Pedido {

	protected String nomeCliente;
	protected int mesa;
	protected LocalTime horario;

	public Pedido(String nomeCliente, int mesa) {

		setNome(nomeCliente);
		setMesa(mesa);
		this.horario = LocalTime.now();
	}
	
	public void setNome(String nomeCliente) {
		
		if (nomeCliente.length() < 4) {
			
			throw new IllegalArgumentException("Nome de cliente muito curto.");
			
		}
		
		this.nomeCliente = nomeCliente;
	}
	
	public void setMesa(int mesa) {
		
		if (mesa < 0 || mesa > 25) {
			
			throw new IllegalArgumentException("Mesa errada.");
			
		}
		
		this.mesa = mesa;
	}
	
	public String getNome() {
		return nomeCliente;
	}
	
	public int getMesa() {
		return mesa;
	}
	
	public LocalTime getHorario() {
		return horario;
	}
	
}
