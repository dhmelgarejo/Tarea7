package edu.uniandes.ecos.Programa7;

import edu.uniandes.ecos.modelo.Logica;
import static org.junit.Assert.*;

import org.junit.Test;

public class PruebasLogica {

	@Test
	public void testCalcularXFinal() {
		assertEquals(-19, Logica.calcularSignificancia(10),0.001);
		assertEquals(0.3, Logica.calcularSignificancia(0.35),0.001);
		assertEquals(11, Logica.calcularSignificancia(-5),0.001);
		assertEquals(0.996, Logica.calcularSignificancia(0.002),0.001);
		assertEquals(2, Logica.calcularSignificancia(-0.5),0.001);
	}
	

}
