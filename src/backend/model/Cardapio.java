package backend.model;

import backend.controller.Controller;

public class Cardapio implements Item {
	
	private String nome;
	private Controller<Produto> produtos = new Controller<Produto>();
	private Controller<Cardapio> sessoes = new Controller<Cardapio>();
	
	@Override
	public String toString() {
		return "Cardápio [getNome()=" + getNome() + "]";
	}
	
	public Controller<Cardapio> getSessoes(){
		return sessoes;
	}
	
	public Controller<Produto> getProdutos(){
		return produtos;
	}
	
	public Cardapio getSessao(String nome) {		
		return sessoes.get(nome);
	}
	
	public Produto getProduto(String produto) {
		produtos.get(produto);
		
		return null;
	}
	
	public Produto getProduto(String sessao, String produto) {		
		return getSessao(sessao).produtos.get(produto);
	}
	
	public Cardapio(String nome) {			
		setNome(nome);
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void addProduto(Produto prod) {
		produtos.add(prod);
	}
	
	public void addSessao(Cardapio sessao) {		
		sessoes.add(sessao);
	}
	
	public void removeProduto(String nome) {
		produtos.remove(nome);
	}
	
	public void removeSessao(String nome) {
		sessoes.remove(nome);
	}
	
	@Override
	public String getClassName() {
		// TODO Auto-generated method stub
		return null;
	}
}
