package edu.uniandes.ecos.controlador;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import edu.uniandes.ecos.modelo.PersistenciaRegresionLineal;

/**
 * Clase para leer datos de entrada desde un archivo
 * @author Melga
 *
 */
public class Lector {
	private PersistenciaRegresionLineal datos;
	private String ruta;
	private BufferedReader br;
	
	/**
	 * Constructor
	 * @param datos
	 */
	public Lector(PersistenciaRegresionLineal datos){
		this.datos = datos;
	}
	
	/**
	 * Metodo para leer datos desde un archivo
	 * @param ruta, String que indica la ruta en el sistema donde se encunetra el archivo
	 * @throws FileNotFoundException
	 */
	public void leerArchivo(String ruta) throws FileNotFoundException{
		this.ruta = ruta;
		br = new BufferedReader(new FileReader(this.ruta));

		try {
		    String line = br.readLine();
		    boolean primeraLinea = true;
		    while (line != null) {
		    	if(primeraLinea){
		    		double xk = Double.parseDouble(line);
		    		datos.setXk(xk);
		    		primeraLinea = false;
		    	}else{
			    	String [] xy = line.split(" ");
			    	System.out.println("X: "+xy[0]+" Y:"+xy[1]);
			    	datos.getDatosX().add(Double.parseDouble(xy[0]));
			    	datos.getDatosY().add(Double.parseDouble(xy[1]));
		    	}
		        line = br.readLine();
		    }
		} catch (IOException e) {
			System.out.println("Ha ocurrido un error, asegurese que el formato del archivo sea adecuado.");
			e.printStackTrace();
		} finally {
		    try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
