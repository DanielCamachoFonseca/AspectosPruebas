package com.edu.uniminuto.aspectospruebas.aspectos;

/**
 *Importacion de la clase controlador
 *que se encuentra en el paquete controlador.
 */
import com.edu.uniminuto.aspectospruebas.controlador.controlador;

/**
 * Esta clase se encarga de ejecutar el cuarto aspecto programado
 * @version 1.1.1
 * @author Julian Camilo Anzola Hincapie.
 * @author Daniel Camacho Fonseca.
 * @author Carolina Ortiz Sosa.
 * @author Johan Alexander Portilla.
 * @Copyright Este programa funciona bajo la licencia de software libre.
 */
public aspect cuartoAspecto {
	
	/**
	 * Metodo encargado de ejecutar el aspecto donde se puede ver el tiempo que
	 * se tardo el sistema en ejecutar el programa
	 */
	before():
		call(float[] controlador.recibirPeticion()) {
		
			long inicio = System.currentTimeMillis();
	        try {
	        	
				Thread.sleep(2000);
				long fin = System.currentTimeMillis();
		        double tiempo = (double) ((fin - inicio)/1000);
		        System.out.println("El programa se demoro ejecutando "+tiempo+" segundos");
		        
			} catch (InterruptedException e) {
				System.out.println("Error en la ejecución del aspecto cuatro");
			}
		}
}
