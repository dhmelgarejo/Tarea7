package edu.uniandes.ecos.Programa7;

import org.junit.Test;

import edu.uniandes.ecos.modelo.IntegracionNumerica;
import junit.framework.TestCase;

public class PruebasLogicaIntegracionNumerica extends TestCase{
	
	@Test
	public void testCalcularXFinal() {
		assertEquals(0.55338, IntegracionNumerica.calcularXFinal(0, 1, 6, 0.20),0.001);
		assertEquals(1.75305, IntegracionNumerica.calcularXFinal(0, 1, 15, 0.45),0.001);
		assertEquals(4.0625, IntegracionNumerica.calcularXFinal(0, 1, 5, 0.495),0.001);
	}
	

	@Test
	public void testCalcularGammaNoEntero() {
		assertEquals(11.63173, IntegracionNumerica.calcularGammaNoEntero(4.5),0.001);
		assertEquals(0.8862269254527579, IntegracionNumerica.calcularGammaNoEntero(1.5),0.001);
		assertEquals(14034.407293483413, IntegracionNumerica.calcularGammaNoEntero(8.5),0.001);
		assertEquals(287.8852778150444, IntegracionNumerica.calcularGammaNoEntero(6.5),0.001);
	}

	@Test
	public void testCalcularFactorial() {
		assertEquals(6, IntegracionNumerica.calcularFactorial(3),0.001);
		assertEquals(3628800, IntegracionNumerica.calcularFactorial(10),0.001);
		assertEquals(120, IntegracionNumerica.calcularFactorial(5),0.001);
		assertEquals(2.43290200817664E18, IntegracionNumerica.calcularFactorial(20),0.001);
	}
	
}
