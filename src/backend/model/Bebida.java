package backend.model;

public class Bebida extends Produto {
	
	private float mL;
	private boolean alcoolica;
	public Bebida(String nome, String desc, float valor, float mL, boolean alcoolica) {
		
		super(nome, desc, valor);
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
	public String toString() {
		
		return "Bebida" + super.toString() + ", getmL()=" + getmL() + ", isAlcoolica()=" + isAlcoolica() + "]";
		//return getNome() + ": " + mL + " mL, " + alcoolicaString();
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
	
	public String alcoolicaString() {
		
		if (alcoolica) return "alcoólica";
		return "não alcoólica";
	}

}
