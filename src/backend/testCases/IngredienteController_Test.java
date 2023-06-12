package backend.testCases;

import org.junit.jupiter.api.Test;

import backend.controller.Controller;
import backend.model.Ingrediente;
import backend.model.Prato;

class IngredienteController_Test {

	@Test
	void test() {
		Controller<Ingrediente> listaIngredientes = new Controller<Ingrediente>();
		listaIngredientes.add(new Ingrediente("Ing 1"));
		listaIngredientes.add(new Ingrediente("Ing 2"));
		Ingrediente i3 = new Ingrediente("Ing 3");
		listaIngredientes.add(i3);
		Controller<Prato> prato = new Controller<Prato>();
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
