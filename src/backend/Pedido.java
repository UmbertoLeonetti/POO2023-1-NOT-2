package backend;

public class Pedido {

	private String nome;

	public Pedido(String nome) {

		setNome(nome);
	}
	
	public void setNome(String nome) {
		
		if (nome.length() < 4) {
			
			throw new IllegalArgumentException("Nome de cliente muito curto.");
			
		}
		
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
}
