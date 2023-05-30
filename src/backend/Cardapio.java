package backend;

import java.util.ArrayList;

public class Cardapio {
	private String nome;
	private ArrayList<Produto> produtos = new ArrayList<Produto>();
	private ArrayList<Cardapio> sessoes = new ArrayList<Cardapio>();
	
	public Cardapio(String nome) {
		setNome(nome);
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void addProduto(Produto prod) {
		produtos.add(prod);
	}
	
	public void addSessao(Cardapio sessao) {
		sessoes.add(sessao);
	}
	
	public void removeProduto(Produto prod) {
		produtos.remove(prod);
	}
	
	public void removeSessao(Cardapio sessao) {
		sessoes.remove(sessao);
	}
}
