package backend.controller;

import com.google.gson.Gson;

import backend.model.Funcionario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioManager {
    private List<Funcionario> funcionarios;

    public FuncionarioManager() {
        funcionarios = new ArrayList<>();
    }

    public void adicionarFuncionario(String nome, String cargo, String horarioTrabalho) {
        Funcionario funcionario = new Funcionario(nome, cargo, horarioTrabalho);
        funcionarios.add(funcionario);
    }

    public void adicionarFuncionarioFromJSON(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder jsonContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonContent.append(line);
            }

            Gson gson = new Gson();
            Funcionario[] funcionariosArray = gson.fromJson(jsonContent.toString(), Funcionario[].class);

            for (Funcionario funcionario : funcionariosArray) {
                adicionarFuncionario(funcionario.getNome(), funcionario.getCargo(), funcionario.getHorarioTrabalho());
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
