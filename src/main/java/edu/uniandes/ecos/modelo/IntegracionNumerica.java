package edu.uniandes.ecos.modelo;

/**
 * Clase con metodos estaticos auxiliares para calcular variables de simpson
 * @author Melga
 *
 */
public class IntegracionNumerica {
	
	/**
	 * Calcula el rango de distancia entre 2 segmentos de una curva
	 * @param datos
	 * @return
	 */
	public static double calcularW(double x, double num_seg){
		return x/num_seg;
	}
	
	/**
	 * Calcula el valor de p segun la formula encontrada en los requisitos
	 * @param datos
	 * @return
	 */
	public static double calcularP(double xI, double xF, double dof, double num_seg){
		double p = 0;
		
		double range = xF - xI;
		double w = calcularW(range, num_seg);

		double fp_equation = calcularFuncionGamma(dof);
		int j = 0;
		double i = xI;
		for (; j <= num_seg; i += w) {
			double col1 = 1 + (Math.pow(i,2)/dof);
			double col2 = Math.pow(col1, -((dof+1)/2));
			double fX = fp_equation * col2;
			double res = 0;
			double multiplier = 0;
			if(j==0 || j==num_seg){
				multiplier = 1;
			}else
				if(j%2 == 0)
					multiplier = 2;
				else
					multiplier = 4;
			
			res += w/3 * multiplier * fX;
			p += res;
			j++;
		}
		return p;
	}
	

	/**
	 * Calcula el factorial de un numero
	 * @param datos
	 * @return
	 */
	public static double calcularFactorial(double x){
		double resp = 1;
		while(x > 1){
			resp *= x;
			x--;
		}
		return resp;
	}

	/**
	 * Calcula el valor gamma para un numero no entero
	 * @return
	 */
	public static double calcularGammaNoEntero(double x){
		x -= 1;
		if(x == 0.5){
			return x * Math.sqrt(Math.PI);
		}else{
			return x * calcularGammaNoEntero(x);
		}
	}
	
	/**
	 * Calcula valores de simpson en varias iteraciones hasta validar que la diferencia sea menor a un epsilon definido
	 * @return
	 */
	public static double calcularSimpson(double xI, double xF, double dof){
		double e = 0.00001;
		double p1 = calcularP(xI, xF, dof, 10);
		double p2 = calcularP(xI, xF, dof, 20);
		double num_seg = 20;
		while(Math.abs(p1 - p2) >= e){
			p1 = calcularP(xI, xF, dof, num_seg);
			p2 = calcularP(xI, xF, dof, num_seg+10);
			num_seg += 20;
		}
		return p2;
	}

	/**
	 * Calcula el valor de xFinal a partir de aproximaciones
	 * @param xI
	 * @param xF
	 * @param dof
	 * @param pFinal
	 * @return
	 */
	public static double calcularXFinal(double xI, double xF, double dof, double pFinal){
		double e = 0.0000000001;
		double p = calcularSimpson(xI, xF, dof);
		double d = 0.5;
		double diferenciaOriginal = 0, diferenciaTmp = 0;
		if(p>pFinal)
			xF -= d;
		else
			xF += d;
		diferenciaOriginal = p - pFinal;
		while(Math.abs(pFinal - p)> e){
			System.out.println();
			p = calcularSimpson(xI, xF, dof);
			diferenciaTmp = p - pFinal;
			if((diferenciaOriginal>=0 && diferenciaTmp<0) || diferenciaOriginal<=0 && diferenciaTmp>0)
				d /= 2;
			if(p>pFinal)
				xF -= d;
			else
				xF += d;
			diferenciaOriginal = p - pFinal;
		}
		return xF;
	}
	
	
	/**
	 * Calcula el valor de la funcion gama segun un grado de libertad
	 * @param grados de libertad
	 * @return
	 */
	public static double calcularFuncionGamma(double dof){
		double numerador, denominador;
		double res_temp = (dof+1)/2;
		if(res_temp - Math.floor(res_temp) == 0)
			numerador = calcularFactorial(res_temp-1);
		else
			numerador = calcularGammaNoEntero(res_temp);

		res_temp = dof/2;
		if(res_temp - Math.floor(res_temp) == 0)
			denominador = calcularFactorial(res_temp-1);
		else
			denominador = calcularGammaNoEntero(res_temp);
		denominador *= Math.pow((dof * Math.PI), 0.5);
		double fp_equation = numerador / denominador;
		return fp_equation;
	}

}
