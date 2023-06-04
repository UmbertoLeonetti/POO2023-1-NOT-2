package backend.model;

public class Ingrediente {
	private String nome;
	private int quantidade;
	private float preco;

	public Ingrediente(String nome, int quantidade, float preco) {
		setNome(nome);
		setQuantidade(quantidade);
		setPreco(preco);
	}
	
	@Override
	public String toString() {
		return getNome();
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		
		if (preco <= 0) {
			
			throw new IllegalArgumentException("Preço de ingrediente deve ser positivo.");
			
		}
		
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		
		if (quantidade < 1) {
			
			throw new IllegalArgumentException("A quantidade do ingrediente deve ser positiva.");
			
		}
		
		this.quantidade = quantidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		
		if (nome.length() == 0) {
			
			throw new IllegalArgumentException("Nome de ingrediente deve conter caracteres.");
			
		}
		this.nome = nome;
	}
	
}
