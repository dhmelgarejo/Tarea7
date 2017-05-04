package edu.uniandes.ecos.vista;

import edu.uniandes.ecos.modelo.Persistencia;

/**
 * Clase auxiliar para mostrar resultados de forma ordenada
 * @author Melga
 *
 */
public class Presentacion {
	
	/**
	 * Metodo estatico que recibe una instancia de la persistencia de datos y realiza la impresion de las
	 * operaciones entre variables para calcular la integracion numerica con metodo de simpson
	 * @param datos
	 */
	public static void mostrarResultados(Persistencia datos){

		System.out.println("Resultado:");
		System.out.println("B0: "+datos.getB0());
		System.out.println("B1: "+datos.getB1());
		
		System.out.println("R: "+datos.getR());
		System.out.println("R2: "+datos.getR2());
		
		System.out.println("Y: "+datos.getY());

		System.out.println("X final: "+datos.getxFinal());
		System.out.println("P: "+datos.getP());
		System.out.println("Significancia: "+datos.getSignificancia());
		System.out.println("Yk: "+datos.getYk());
		System.out.println("Range 70: "+datos.getRange70());
		System.out.println("UPI: "+datos.getUPI());
		System.out.println("LPI: "+datos.getLPI());
		
//		System.out.println("Resultado:");
//		System.out.println("x Inicial: "+datos.getxInicial());
//		System.out.println("x Final: "+datos.getxFinal());
//		System.out.println("dof: "+datos.getDof());
//		System.out.println("p: "+datos.getP());
//		System.out.println("------");
	}
	
}
