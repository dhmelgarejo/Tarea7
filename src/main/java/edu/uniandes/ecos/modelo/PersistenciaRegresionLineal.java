package edu.uniandes.ecos.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase para almacenar en una estructora de datos las variables mas relevantes para 
 * el calculo de una regresion lineal 
 * @author Melga
 *
 */
public class PersistenciaRegresionLineal {

	// VARIABLES 
	private List<Double> datosX;
	private List<Double> datosY;
	private double promedioX;
	private double promedioY;
	private double sumatoriaX;
	private double sumatoriaY;
	private double sumatoriaMultiplicacionXY;
	private double sumatoriaCuadradoY;
	private double sumatoriaCuadradoX;
	private double B0;
	private double B1;
	private double R;
	private double R2;
	private double Y;
	private double X;
	
	// Nuevos campos
	private double P;
	private double xFinal;
	private double significancia;
	private double Yk;
	private double Xk;
	private double range70;
	private double UPI;
	private double LPI;
	
	/**
	 * Constructor
	 * @param datosX
	 * @param datosY
	 */
	public PersistenciaRegresionLineal(){
		this.datosX = new ArrayList<Double>();
		this.datosY = new ArrayList<Double>();
	}
	
	/**
	 * Calcula los valores de las variables en el orden necesario usando las clases de los metodos
	 * definidos en RegresionLineal.java
	 */
	public void calcularRangos(){
		this.promedioX = RegresionLineal.calcularPromedio(datosX);
		this.promedioY = RegresionLineal.calcularPromedio(datosY);
		
		this.sumatoriaX = RegresionLineal.calcularSumatoria(datosX);
		this.sumatoriaY = RegresionLineal.calcularSumatoria(datosY);
		
		this.sumatoriaCuadradoX = RegresionLineal.calcularSumatoriaAlCuadrado(datosX);
		this.sumatoriaCuadradoY = RegresionLineal.calcularSumatoriaAlCuadrado(datosY);
		
		this.sumatoriaMultiplicacionXY = RegresionLineal.calcularSumatoriaMultiplicacionXY(datosX, datosY);		
		
		this.B1 = RegresionLineal.calcularB1(promedioX, promedioY, sumatoriaMultiplicacionXY, sumatoriaCuadradoX, (double)datosX.size());
		this.B0 = RegresionLineal.calcularB0(B1, promedioX, promedioY);
		
		this.R = RegresionLineal.calcularR((double) datosX.size(), sumatoriaMultiplicacionXY, sumatoriaX, sumatoriaY, sumatoriaCuadradoX, sumatoriaCuadradoY);
		this.R2 = RegresionLineal.calcularR2( this.R);
		
		this.Y = RegresionLineal.calcularY(this.B0, this.B1, this.X );
		

		this.xFinal = Logica.calcularX(this.R, datosX.size());
		this.P = Logica.calcularP(0, xFinal, datosX.size()-2);
		this.significancia = Logica.calcularSignificancia(P);
		this.Yk = Logica.calcularYk(B0, B1, Xk);
		this.range70 = Logica.range(B0, B1, datosY, datosX, promedioX, Xk);
		this.UPI = Yk+range70;
		this.LPI = Yk-range70;
	}

	// SETTERS Y GETTERS
	
	
	
	public List<Double> getDatosX() {
		return datosX;
	}
	public double getUPI() {
		return UPI;
	}

	public double getLPI() {
		return LPI;
	}

	public double getYk() {
		return Yk;
	}

	public double getRange70() {
		return range70;
	}

	public List<Double> getDatosY() {
		return datosY;
	}

	public double getB0() {
		return B0;
	}

	public double getB1() {
		return B1;
	}

	public double getR() {
		return R;
	}

	public double getR2() {
		return R2;
	}

	public double getY() {
		return Y;
	}

	public double getX() {
		return X;
	}
	
	public void setX(double x) {
		X = x;
	}
	
	public void setXk(double xk) {
		Xk = xk;
	}

	public double getP() {
		return P;
	}

	public double getxFinal() {
		return xFinal;
	}

	public double getSignificancia() {
		return significancia;
	}

}