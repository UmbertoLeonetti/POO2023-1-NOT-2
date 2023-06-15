package backend.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class TesteToString {
	
	public static void main(String[] args) {
		
		Prato feijoada = new Prato("Feijoada", "Muito bom", 19, 1000);
		Ingrediente arroz = new Ingrediente("Arroz");
		Ingrediente feijao = new Ingrediente("Feijão");
		feijoada.addIngrediente(arroz);
		feijoada.addIngrediente(feijao);
		System.out.println(feijoada);
		System.out.println(arroz);
		System.out.println(feijao + "\n");
		
		Bebida sucoLaranja = new Bebida("Suco de laranja", "suculento", 5, 500, false);
		Ingrediente laranja = new Ingrediente("Laranja");
		sucoLaranja.addIngrediente(laranja);
		System.out.println(sucoLaranja);
		System.out.println(laranja + "\n");
		
		Reserva fulano = new Reserva("Fulano", LocalDate.now(), LocalTime.now());
		fulano.getProdutos().add(feijoada);
		fulano.getProdutos().add(sucoLaranja);
		System.out.println(fulano);
	}

}
