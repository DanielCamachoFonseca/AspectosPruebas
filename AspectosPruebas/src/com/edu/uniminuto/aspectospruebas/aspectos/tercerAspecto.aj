package com.edu.uniminuto.aspectospruebas.aspectos;

/**
 *Importacion de la clase informacionMemoria
 *que se encuentra en el paquete modelo.
 */
import com.edu.uniminuto.aspectospruebas.modelo.informacionMemoria;

/**
 * Esta clase se encarga de ejecutar el tercer aspecto programado
 * @version 1.1.1
 * @author Julian Camilo Anzola Hincapie.
 * @author Daniel Camacho Fonseca.
 * @author Carolina Ortiz Sosa.
 * @author Johan Alexander Portilla.
 * @Copyright Este programa funciona bajo la licencia de software libre.
 */
public aspect tercerAspecto {
	
	/**
	 * Atributo donde se guarda las veces que se a consultado la memoria RAM
	 */
	private long ejecuciones;
	
	/**
	 * Constructor de la clase
	 */
	public tercerAspecto() {
		this.ejecuciones=1;
	}
	
	/**
	 * Metodo encargado de ejecutar el aspecto donde se puede ver cuantas veces se consulta
	 * la informacion de la memoria RAM
	 */
	before():
		call(double informacionMemoria.extraerInformacionMemoria()) {
		System.out.println("Veces que se a ejecutado la consulta de la memoria RAM "+ejecuciones);
		ejecuciones =ejecuciones+ejecuciones;
		}
}
