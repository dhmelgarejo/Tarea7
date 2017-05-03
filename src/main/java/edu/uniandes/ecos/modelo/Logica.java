package edu.uniandes.ecos.modelo;

import java.util.List;

/**
 * Clase con metodos estaticos auxiliares para calcular variables de simpson
 * @author Melga
 *
 */
public class Logica {

	public static double desviacionEstandar(int n, double b0, double b1,List<Double> datosX, List<Double> datosY){
		double result = 0;
		for (int i = 0; i < datosX.size(); i++) {
			result += Math.pow(datosY.get(i)-b0-b1*datosX.get(i),2);
		}
		return Math.sqrt((1/((double)n-2))*result);
	}
	
	public static double calcularX(double correlacion, double n){
		double x = 0;
		x = Math.abs(correlacion) * Math.sqrt(n-2) / Math.sqrt(1-Math.pow(correlacion, 2));
		return x;
	}

	public static double calcularP(double xInicial, double xFinal, double dof){
		return IntegracionNumerica.calcularSimpson(xInicial, xFinal, dof);
	}
	
	public static double calcularSignificancia(double p){
		return 1-2*p;
	}

	public static double calcularYk(double b0, double b1, double Xk){
		return b0 + b1*Xk;
	}

	public static double sumatoriaXmenosPromedio(List<Double> datos, double promedio){
		double res = 0;
		for (int i = 0; i < datos.size(); i++) 
			res += Math.pow(datos.get(i)-promedio, 2);
		
		return res;
	}
	
	public static double range(double b0, double b1,List<Double> datosY, List<Double> datosX, double promedioX, double Xk){

		double desviacion = desviacionEstandar(datosY.size(), b0, b1, datosX, datosY);
		double sum = sumatoriaXmenosPromedio(datosX, promedioX);
		double t = IntegracionNumerica.calcularXFinal(0, 1, datosY.size()-2, 0.35);
		double tercero = Math.sqrt(1+(1/(double)datosY.size())+(Math.pow(Xk - promedioX, 2)/sum));
		return t*desviacion*tercero;
	}
}
