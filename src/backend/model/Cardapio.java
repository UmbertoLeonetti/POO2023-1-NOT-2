package backend.model;

import java.util.ArrayList;

public class Cardapio {
	
	private String nome;
	private ArrayList<Produto> produtos = new ArrayList<Produto>();
	private ArrayList<Cardapio> sessoes = new ArrayList<Cardapio>();
	
	@Override
	public String toString() {
		
		return nome;
		
	}
	
	public Cardapio(String nome) {
		
		if(nome.length() == 0) {
			
			throw new IllegalArgumentException("Nome de cardápio deve conter caracteres.");
			
		}
		
		setNome(nome);
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void addProduto(Produto prod) {
		
		if (sessoes.size() > 0)  {
			
			throw new IllegalArgumentException("Adicione o produto em uma sessão do cardápio.");
			
		}
		
		if (produtos.contains(prod)) {
			
			throw new IllegalArgumentException("Este produto já está presente neste cardápio/sessão.");
			
		}
		
		
		produtos.add(prod);
	}
	
	public void addSessao(Cardapio sessao) {
		
		if (produtos.size() > 0) {
			
			throw new IllegalAccessError("Já há produtos neste cardápio/sessão.");
			
		}
		
		sessoes.add(sessao);
	}
	
	public boolean removeProduto(Produto prod) {
		return produtos.remove(prod);
	}
	
	public boolean removeSessao(Cardapio sessao) {
		return sessoes.remove(sessao);
	}
}
