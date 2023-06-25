package backend.model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Funcionario {
    private String nome;
    private String cargo;
    private LocalDateTime horarioTrabalho;

    public Funcionario(String nome, String cargo, LocalDateTime horarioTrabalho) {
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

    public LocalDateTime getHorarioTrabalho() {
        return horarioTrabalho;
    }

    public LocalTime getHorarioTrabalhoAsLocalTime() {
        return horarioTrabalho.toLocalTime();
    }

    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Cargo: " + cargo);
        System.out.println("Horário de Trabalho: " + horarioTrabalho.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }
}
