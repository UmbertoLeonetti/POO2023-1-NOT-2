
package backend.model;

import java.time.LocalTime;

public class Funcionario implements Item {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
    private String cargo;
    private String horarioTrabalho;

    public Funcionario(String nome, String cargo, String horarioTrabalho) {
        setNome(nome);
        setCargo(cargo);
        setHorarioTrabalho(horarioTrabalho);
    }

    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Cargo: " + cargo);
        System.out.println("Horário de Trabalho: " + horarioTrabalho);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getHorarioTrabalho() {
        return horarioTrabalho;
    }

    public void setHorarioTrabalho(String horarioTrabalho2) {
        this.horarioTrabalho = horarioTrabalho2;
    }
    
    @Override
    public String toString() {
    	return super.toString();
    }

	@Override
	public String getClassName() {
		// TODO Auto-generated method stub
		return null;
	}
}
