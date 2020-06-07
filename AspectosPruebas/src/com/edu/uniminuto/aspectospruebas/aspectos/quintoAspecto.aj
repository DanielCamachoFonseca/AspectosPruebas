package com.edu.uniminuto.aspectospruebas.aspectos;

/**
 *Importacion de la clase controlador
 *que se encuentra en el paquete controlador.
 */
import com.edu.uniminuto.aspectospruebas.controlador.controlador;

/**
 * Esta clase se encarga de ejecutar el quinto aspecto programado
 * @version 1.1.1
 * @author Julian Camilo Anzola Hincapie.
 * @author Daniel Camacho Fonseca.
 * @author Carolina Ortiz Sosa.
 * @author Johan Alexander Portilla.
 * @Copyright Este programa funciona bajo la licencia de software libre.
 */

public aspect quintoAspecto {
	
	/**
	 * Instrucción encargada de ejecutar el aspecto cuando se llama el metodo de recibirPeticion de la
	 * clase controlador
	 */
	pointcut greeting(): execution(* controlador.recibirPeticion(..));
	
	/**
	 * Ejecución del aspecto donde se mostrara el total de memoria utilizado por la aplicación
	 */
	after() returning(): greeting(){
		Runtime runtime= Runtime.getRuntime();
		System.out.println("El programa consume el total de memoria de "+
							(runtime.totalMemory()-runtime.freeMemory())/(1024*1024)+" MB");
	}
}
