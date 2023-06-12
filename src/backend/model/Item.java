package backend.model;

import java.io.Serializable;

public interface Item extends Serializable {
	public String getNome();
	
	@Override
	public String toString();
}
