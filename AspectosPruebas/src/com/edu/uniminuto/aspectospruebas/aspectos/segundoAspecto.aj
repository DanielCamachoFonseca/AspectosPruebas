package com.edu.uniminuto.aspectospruebas.aspectos;

/**
 *Importacion de todas las clases
 *que se encuentra en el paquete modelo.
 */
import com.edu.uniminuto.aspectospruebas.modelo.*;

/**
 * Esta clase se encarga de ejecutar el segundo aspecto programado
 * @version 1.1.1
 * @author Julian Camilo Anzola Hincapie.
 * @author Daniel Camacho Fonseca.
 * @author Carolina Ortiz Sosa.
 * @author Johan Alexander Portilla.
 * @Copyright Este programa funciona bajo la licencia de software libre.
 */
public aspect segundoAspecto {
	
	/**
	 * Metodo encargado de ejecutar el aspecto donde se puede ver si se ejecuto el
	 * metodo de extraerInformacionDisco
	 */
	before():
		call(float[] informacionDisco.extraerInformacionDisco()) {
		System.out.println("El metodo que extrae la informacion del disco se a ejecutado" );
		}
	
	/**
	 * Metodo encargado de ejecutar el aspecto donde se puede ver si se ejecuto el
	 * metodo de extraerInformacionDiscoDañado
	 */
	before():
		call(float[] informacionDisco.extraerInformacionDiscoDañado()) {
		System.out.println("El metodo que extrae la informacion del disco dañado se a ejecutado" );
		}
	
	/**
	 * Metodo encargado de ejecutar el aspecto donde se puede ver si se ejecuto el
	 * metodo de tamanoArchivos
	 */
	before():
		call(float[] informacionDisco.tamanoArchivos()) {
		System.out.println("El metodo que extrae la informacion del tamaño de los archivos se a ejecutado" );
		}
}
