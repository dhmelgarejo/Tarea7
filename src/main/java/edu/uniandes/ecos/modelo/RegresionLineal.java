package edu.uniandes.ecos.modelo;

import java.util.LinkedList;
import java.util.List;

/**
 * Clase con metodos estaticos auxiliares para calcular varaibles de regresion lineal
 * @author Melga
 *
 */
public class RegresionLineal {
	
	/**
	 * Calcula el promedio a partir de una lista de datos
	 * @param datos
	 * @return
	 */
	public static double calcularPromedio(List<Double> datos){
		double respuesta = 0;
		for (Double temp : datos) 
			respuesta += temp;
		return respuesta/datos.size();
	}
	
	/**
	 * Calcula la sumatoria de una lista de datos	
	 * @param datos
	 * @return
	 */
	public static double calcularSumatoria(List<Double> datos){
		double respuesta = 0;
		for (Double temp : datos) 
			respuesta += temp;
		return respuesta;
	}

	/**
	 * Calcula la sumatoria de una serie de datos elevada al cuadrado, usa metodo calcularSumatoria
	 * @param datos
	 * @return
	 */
	public static double calcularSumatoriaAlCuadrado(List<Double> datos){
		List<Double> datosNuevos = new LinkedList<Double>();
		for (Double temp : datos) 
			datosNuevos.add(Math.pow(temp, 2));
		
		return calcularSumatoria(datosNuevos);
	}
	
	/**
	 * Calcula la multiplicacion de valores en el mismo indice y suma el resultado total
	 * @param datosX
	 * @param datosY
	 * @return
	 */
	public static double calcularSumatoriaMultiplicacionXY(List<Double> datosX,List<Double> datosY){
		double respuesta = 0;
		for (int i = 0; i < datosX.size(); i++) {
			respuesta += datosX.get(i)*datosY.get(i);
		}
		return respuesta;
	}
	
	/**
	 * Calcula B1 de acuerdo a la formula definida en los requisitos
	 * @param promX, promedio de X
	 * @param promY, promedio de Y
	 * @param sumMulti, resultado de calcularSumatoriaMultiplicacionXY()
	 * @param sumCuadradoX, resultado de calcularSumatoriaAlCuadrado()
	 * @param n, tamaño de la lista
	 * @return
	 */
	public static double calcularB1(double promX, double promY, double sumMulti, double sumCuadradoX, double n){
		double respuesta = 0;
		respuesta = (sumMulti - (n*promX*promY)) / (sumCuadradoX - (n*Math.pow(promX, 2)));
		return respuesta;
	}
	
	/**
	 * Calcula B0, requiere resultado previo de B1
	 * @param B1
	 * @param promX
	 * @param promY
	 * @return
	 */
	public static double calcularB0(double B1, double promX, double promY){
		double respuesta = 0;
		respuesta = promY - B1*promX;
		return respuesta;
	}
	
	/**
	 * Calcula el valor de R de acuerdo a la formula definida en los requisitos
	 * @param n
	 * @param sumMultiXY, resultado de calcularSumatoriaMultiplicacionXY()
	 * @param sumX, sumatoria de datos
	 * @param sumY, sumatoria de datos
	 * @param sumCuadradoX, resultado de calcularSumatoriaAlCuadrado()
	 * @param sumCuadradoY, resultado de calcularSumatoriaAlCuadrado()
	 * @return
	 */
	public static double calcularR(double n, double sumMultiXY, double sumX, double sumY, double sumCuadradoX, double sumCuadradoY){
		double numerador = n*sumMultiXY - sumX*sumY;
		double denominador = Math.sqrt( (n*sumCuadradoX-Math.pow(sumX, 2)) * (n*sumCuadradoY-Math.pow(sumY, 2)) );
		
		return numerador / denominador;
	}
	
	/**
	 * Calcula el valor de R2 de acuerdo a la formula definida en los requisitos
	 * Requiere el valor de R
	 * @param R
	 * @return
	 */
	public static double calcularR2(double R){
		return R * R;
	}

	
	/**
	 * Calcula el valor de Y en la formula lineal
	 * @param R
	 * @return
	 */
	public static double calcularY(double B0, double B1, double X){
		return B0 + B1 * X;
	}
	
	public static double redondearCifras(double numero, int cifras){
		double cifras_redondeo = Math.pow(10, cifras);
		return Math.round(numero * cifras_redondeo) / cifras_redondeo;
	}
}
