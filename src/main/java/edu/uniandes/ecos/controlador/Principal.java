package edu.uniandes.ecos.controlador;

import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;
import static spark.Spark.*;

import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.uniandes.ecos.modelo.Persistencia;
import edu.uniandes.ecos.vista.Presentacion;


/**
	* Programa 7 - Calculo de rangos
	* ECOS Primer Semestre de 2017
	*
	* @author  Daniel Melgarejo
**/
public class Principal {
	public static void main(String[] args) {
		
	    port(Integer.valueOf(System.getenv("PORT")));
	    staticFileLocation("/public");
	    
		Scanner in = new Scanner(System.in);
		String ruta1 = "target/classes/public/test1.txt";
//		String ruta = "C:/Users/Melga/workspace/Programa7/src/main/resources/public/test3.txt";
		
		Persistencia datos = new Persistencia();
		Lector lector = new Lector(datos);
		try {
			lector.leerArchivo(ruta1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		datos.calcularRangos();
		Presentacion.mostrarResultados(datos);
		//Impresion de resultados
		
		String ruta2 = "target/classes/public/test2.txt";
		Persistencia datos2 = new Persistencia();
		Lector lector2 = new Lector(datos2);
		try {
			lector2.leerArchivo(ruta2);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		datos2.calcularRangos();
		//Impresion de resultados
		Presentacion.mostrarResultados(datos2);
		
		String ruta3 = "target/classes/public/test3.txt";
		Persistencia datos3 = new Persistencia();
		Lector lector3 = new Lector(datos3);
		try {
			lector3.leerArchivo(ruta3);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		datos3.calcularRangos();
		//Impresion de resultados
		Presentacion.mostrarResultados(datos3);

		String ruta4 = "target/classes/public/test4.txt";
		Persistencia datos4 = new Persistencia();
		Lector lector4 = new Lector(datos4);
		try {
			lector4.leerArchivo(ruta4);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		datos4.calcularRangos();
		//Impresion de resultados
		Presentacion.mostrarResultados(datos4);
		
		get("/", (req, res) -> 
			"<h2>Expected Values</h2>"+
			"<table border='1'>"+
			"<th>Test</th>"+
			"<th>Parameter</th>"+
			"<th>Expected Value</th>"+
			"<th>Actual Value</th>"+
			"<tr>"+
				"<td rowspan='9'>Test 1</td>"+
				"<td>r</td>"+
				"<td>0.954496574</td>"+
				"<td>"+datos.getR()+"</td>"+
			"</tr>"+
			"<tr>"+
				"<td>r2</td>"+
				"<td>0.91106371</td>"+
				"<td>"+datos.getR2()+"</td>"+
			"</tr>"+
			"<tr>"+
				"<td>significancia</td>"+
				"<td>1.77517E-05</td>"+
				"<td>"+datos.getSignificancia()+"</td>"+
			"</tr>"+
			"<tr>"+
				"<td>B0</td>"+
				"<td>-22.55253275</td>"+
				"<td>"+datos.getB0()+"</td>"+
			"</tr>"+
			"<tr>"+
				"<td>B1</td>"+
				"<td>1.727932426</td>"+
				"<td>"+datos.getB1()+"</td>"+
			"</tr>"+
			"<tr>"+
				"<td>Yk</td>"+
				"<td>644.4293838</td>"+
				"<td>"+datos.getYk()+"</td>"+
			"</tr>"+
			"<tr>"+
				"<td>Range</td>"+
				"<td>230.0017197</td>"+
				"<td>"+datos.getRange70()+"</td>"+
			"</tr>"+
			"<tr>"+
				"<td>UPI</td>"+
				"<td>874.4311035</td>"+
				"<td>"+datos.getUPI()+"</td>"+
			"</tr>"+
			"<tr>"+
				"<td>LPI</td>"+
				"<td>414.427664</td>"+
				"<td>"+datos.getLPI()+"</td>"+
			"</tr>"+

			"<tr>"+
				"<td rowspan='9'>Test 2</td>"+
				"<td>r</td>"+
				"<td>0.933306898</td>"+
				"<td>"+datos2.getR()+"</td>"+
			"</tr>"+
			"<tr>"+
				"<td>r2</td>"+
				"<td>0.871061766</td>"+
				"<td>"+datos2.getR2()+"</td>"+
			"</tr>"+
			"<tr>"+
				"<td>significancia</td>"+
				"<td>7.98203E-05</td>"+
				"<td>"+datos2.getSignificancia()+"</td>"+
			"</tr>"+
			"<tr>"+
				"<td>B0</td>"+
				"<td>-4.038881575</td>"+
				"<td>"+datos2.getB0()+"</td>"+
			"</tr>"+
			"<tr>"+
				"<td>B1</td>"+
				"<td>0.16812665</td>"+
				"<td>"+datos2.getB1()+"</td>"+
			"</tr>"+
			"<tr>"+
				"<td>Yk</td>"+
				"<td>60.85800528</td>"+
				"<td>"+datos2.getYk()+"</td>"+
			"</tr>"+
			"<tr>"+
				"<td>Range</td>"+
				"<td>27.55764748</td>"+
				"<td>"+datos2.getRange70()+"</td>"+
			"</tr>"+
			"<tr>"+
				"<td>UPI</td>"+
				"<td>88.41565276</td>"+
				"<td>"+datos2.getUPI()+"</td>"+
			"</tr>"+
			"<tr>"+
				"<td>LPI</td>"+
				"<td>33.3003578</td>"+
				"<td>"+datos2.getLPI()+"</td>"+
			"</tr>"+

			"<tr>"+
				"<td rowspan='9'>Test 3</td>"+
				"<td>r</td>"+
				"<td>n/a</td>"+
				"<td>"+datos3.getR()+"</td>"+
			"</tr>"+
			"<tr>"+
				"<td>r2</td>"+
				"<td>n/a</td>"+
				"<td>"+datos3.getR2()+"</td>"+
			"</tr>"+
			"<tr>"+
				"<td>significancia</td>"+
				"<td>n/a</td>"+
				"<td>"+datos3.getSignificancia()+"</td>"+
			"</tr>"+
			"<tr>"+
				"<td>B0</td>"+
				"<td>n/a</td>"+
				"<td>"+datos3.getB0()+"</td>"+
			"</tr>"+
			"<tr>"+
				"<td>B1</td>"+
				"<td>n/a</td>"+
				"<td>"+datos3.getB1()+"</td>"+
			"</tr>"+
			"<tr>"+
				"<td>Yk</td>"+
				"<td>n/a</td>"+
				"<td>"+datos3.getYk()+"</td>"+
			"</tr>"+
			"<tr>"+
				"<td>Range</td>"+
				"<td>n/a</td>"+
				"<td>"+datos3.getRange70()+"</td>"+
			"</tr>"+
			"<tr>"+
				"<td>UPI</td>"+
				"<td>n/a</td>"+
				"<td>"+datos3.getUPI()+"</td>"+
			"</tr>"+
			"<tr>"+
				"<td>LPI</td>"+
				"<td>n/a</td>"+
				"<td>"+datos3.getLPI()+"</td>"+
			"</tr>"+


			"<tr>"+
				"<td rowspan='9'>Test43</td>"+
				"<td>r</td>"+
				"<td>n/a</td>"+
				"<td>"+datos4.getR()+"</td>"+
			"</tr>"+
			"<tr>"+
				"<td>r2</td>"+
				"<td>n/a</td>"+
				"<td>"+datos4.getR2()+"</td>"+
			"</tr>"+
			"<tr>"+
				"<td>significancia</td>"+
				"<td>n/a</td>"+
				"<td>"+datos4.getSignificancia()+"</td>"+
			"</tr>"+
			"<tr>"+
				"<td>B0</td>"+
				"<td>n/a</td>"+
				"<td>"+datos4.getB0()+"</td>"+
			"</tr>"+
			"<tr>"+
				"<td>B1</td>"+
				"<td>n/a</td>"+
				"<td>"+datos4.getB1()+"</td>"+
			"</tr>"+
			"<tr>"+
				"<td>Yk</td>"+
				"<td>n/a</td>"+
				"<td>"+datos4.getYk()+"</td>"+
			"</tr>"+
			"<tr>"+
				"<td>Range</td>"+
				"<td>n/a</td>"+
				"<td>"+datos4.getRange70()+"</td>"+
			"</tr>"+
			"<tr>"+
				"<td>UPI</td>"+
				"<td>n/a</td>"+
				"<td>"+datos4.getUPI()+"</td>"+
			"</tr>"+
			"<tr>"+
				"<td>LPI</td>"+
				"<td>n/a</td>"+
				"<td>"+datos4.getLPI()+"</td>"+
			"</tr>"+
			"</table>"
		);
	}
}
