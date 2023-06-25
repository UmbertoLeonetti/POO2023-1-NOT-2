package backend.controller;

import com.google.gson.Gson;

import backend.model.Funcionario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioManager {
    private List<Funcionario> funcionarios;

    public FuncionarioManager() {
        funcionarios = new ArrayList<>();
    }

    public void adicionarFuncionario(String nome, String cargo, LocalDateTime horarioTrabalho) {
        Funcionario funcionario = new Funcionario(nome, cargo, horarioTrabalho);
        funcionarios.add(funcionario);
    }

    public void adicionarFuncionarioFromJSON(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            Gson gson = new Gson();
            
            
            Funcionario[] funcionariosArray = gson.fromJson(reader, Funcionario[].class);

            for (Funcionario funcionario : funcionariosArray) {
                String nome = funcionario.getNome();
                String cargo = funcionario.getCargo();
                LocalDateTime horarioTrabalho = funcionario.getHorarioTrabalho();

                adicionarFuncionario(nome, cargo, horarioTrabalho);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exibirFuncionarios() {
        for (Funcionario funcionario : funcionarios) {
            funcionario.exibirInformacoes();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        FuncionarioManager manager = new FuncionarioManager();
        manager.adicionarFuncionarioFromJSON("funcionario.json");
        manager.exibirFuncionarios();
    }
}
