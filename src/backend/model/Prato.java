package backend.model;

public class Prato extends Produto{

	private float quilos;
	private boolean vegetariano;

	public Prato(String nome, String desc, float valor, float quilos, boolean vegetariano) {
		super(nome, desc, valor);
		setQuilos(quilos);
		this.vegetariano = vegetariano;
	}

	@Override
	//Sem implementação específica da classe.
	public String toString() {
		return nome;
	}

	public void setQuilos(float quilos) {
		if (quilos <= 0) {
			
			throw new IllegalArgumentException("O valor de quilos do prato deve ser positivo");
			
		}
		
		this.quilos = quilos;
	}
	
	public float getQuilos() {
		return quilos;
	}

	public void setVegetariano(boolean vegetariano) {
		this.vegetariano = vegetariano;
	}
	
	public boolean isVegetariano() {
		return vegetariano;
	}

}
