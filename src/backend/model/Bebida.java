package backend.model;

public class Bebida extends Produto {
	
	private float mL;
	private boolean alcoolica;
	public Bebida(String nome, String desc, float valor, float mL, boolean alcoolica) {
		
		super(nome);
		setmL(mL);
		this.alcoolica = alcoolica;
	}
	
	public void setmL(float mL) {
		if (mL <= 0) {
			throw new IllegalArgumentException("Valor em mL deve ser positivo.");
		}
		
		this.mL = mL;
	}
	
	@Override
	//Sem implementação específica da classe.
	public String toString() {
		return getNome();
	}
	
	public float getmL() {
		return mL;
	}
	
	public void setAlcoolica(boolean alcoolica) {
		this.alcoolica = alcoolica;
	}
	
	public boolean isAlcoolica() {
		return alcoolica;
	}

}
