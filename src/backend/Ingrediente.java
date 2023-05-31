package backend;

public class Ingrediente {
	
	private String nome;

	public Ingrediente(String nome) {

		setNome(nome);
	}
	
	public void setNome(String nome) {
		
		if (nome.length() < 4) {
			
			throw new IllegalArgumentException("Nome de ingrediente muito curto.");
			
		}
		
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
}
