package backend.testCases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import backend.controller.IngredienteController;
import backend.controller.PratoController;
import backend.model.Ingrediente;
import backend.model.Prato;

class IngredienteController_Test {

	@Test
	void test() {
		IngredienteController listaIngredientes = new IngredienteController();
		listaIngredientes.add(new Ingrediente("Ing 1"));
		listaIngredientes.add(new Ingrediente("Ing 2"));
		Ingrediente i3 = new Ingrediente("Ing 3");
		listaIngredientes.add(i3);
		System.out.println(listaIngredientes.getListaIngredientes());
		PratoController prato = new PratoController();
		//System.out.println(prato.get(1));

//		assertEquals(i3, listaIngredientes.get("Ing 3"));
//
//		listaIngredientes.remove(i3);
//
//		assertEquals(null, listaIngredientes.get("Ing 3"));
//		String[] nomes = listaIngredientes.getNomes().toArray(new String[listaIngredientes.getNomes().size()]);
//		assertTrue("Ing 1".compareTo(nomes[0]) == 0);
//		assertTrue("Ing 2".compareTo(nomes[1]) == 0);
	}

//	@Test
//	void testPrato() {
//		IngredienteController listaIngrediente = new IngredienteController();
//		listaIngrediente.add(new Ingrediente("Ing 1"));
//		listaIngrediente.add(new Ingrediente("Ing 2"));
//		Ingrediente i3 = new Ingrediente("Ing 3");
//		listaIngrediente.add(i3);
//		PratoController prato = new PratoController();
//		System.out.println(prato.get(1));
//
//	}

}
