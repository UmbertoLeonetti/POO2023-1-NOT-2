package backend.testCases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import backend.controller.IngredienteController;
import backend.model.Ingrediente;

class IngredienteController_Test {

	@Test
	void test() {
		IngredienteController con = new IngredienteController();
		con.add(new Ingrediente("Ing 1"));
		con.add(new Ingrediente("Ing 2"));
		Ingrediente i3 = new Ingrediente("Ing 3");
		con.add(i3);
		
		assertEquals(i3, con.get("Ing 3"));
		
		con.remove(i3);
		
		assertEquals(null, con.get("Ing 3"));
		String[] nomes = con.getNomes().toArray(new String[con.getNomes().size()]);
		assertTrue("Ing 1".compareTo(nomes[0]) == 0);
		assertTrue("Ing 2".compareTo(nomes[1]) == 0);
	}

}
