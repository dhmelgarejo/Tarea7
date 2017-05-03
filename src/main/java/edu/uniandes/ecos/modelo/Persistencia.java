package edu.uniandes.ecos.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase para almacenar en una estructora de datos las variables mas relevantes para 
 * el calculo de una integral numerica con el metodo de simpson
 * @author Melga
 *
 */
public class Persistencia {

	// VARIABLES 
	private double xInicial;
	private double xFinal;
	private double dof;
	private double p;
	
	/**
	 * Constructor
	 */
	public Persistencia(){
	}
	
	/**
	 * Calcula los valores de las variables en el orden necesario usando las clases de los metodos
	 * definidos en Logica.java
	 */
	public void calcularXFinal(){
//		this.xFinal = Logica.calcularXFinal(0, 1, dof, p);
	}
	
	// SETTERS Y GETTERS

	public double getxInicial() {
		return xInicial;
	}

	public double getxFinal() {
		return xFinal;
	}

	public double getDof() {
		return dof;
	}

	public double getP() {
		return p;
	}

	public void setxInicial(double xInicial) {
		this.xInicial = xInicial;
	}

	public void setxFinal(double xFinal) {
		this.xFinal = xFinal;
	}

	public void setDof(double dof) {
		this.dof = dof;
	}
	
	public void setP(double p) {
		this.p = p;
	}
	
}
