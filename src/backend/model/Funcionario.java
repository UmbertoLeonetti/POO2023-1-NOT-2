package backend.model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Funcionario {
    private String nome;
    private String cargo;
    private String horarioTrabalho;

    public Funcionario(String nome, String cargo, String horarioTrabalho) {
        this.nome = nome;
        this.cargo = cargo;
        this.horarioTrabalho = horarioTrabalho;
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }
    
    public String getHorarioTrabalho() {
		return horarioTrabalho;
	}

	public void exibirInformacoes() {
		System.out.println("Nome: " + nome);
        System.out.println("Cargo: " + cargo);
        System.out.println("Horário de Trabalho: " + horarioTrabalho);

		
	}
}