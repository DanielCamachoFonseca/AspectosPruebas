package com.edu.uniminuto.aspectospruebas.aspectos;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *Importacion de la clase vistaSecundariaArchivos
 *que se encuentra en el paquete vista.
 */
import com.edu.uniminuto.aspectospruebas.vista.*;

/**
 * Esta clase se encarga de ejecutar el septimo aspecto programado
 * @version 1.1.1
 * @author Julian Camilo Anzola Hincapie.
 * @author Daniel Camacho Fonseca.
 * @author Carolina Ortiz Sosa.
 * @author Johan Alexander Portilla.
 * @Copyright Este programa funciona bajo la licencia de software libre.
 */

public aspect septimoAspecto {
	
	
	/**
	 * Instrucción encargada de ejecutar el aspecto cuando se llama el metodo de jButton3ActionPerformed de la
	 * clase vistaPrincipal
	 */
	pointcut greeting(): execution(* vistaPrincipal.jButton3ActionPerformed(..));
	
	/**
	 * Ejecución del aspecto donde se mostrara el tamaño del alto y ancho de la vista donde
	 * se puede ver el tamaño de los archivos
	 */
	after() returning(): greeting(){
		vistaSecundariaArchivos vista=new vistaSecundariaArchivos();
		System.out.println("El tamaño de la vista donde se presenta los archivos es de: \n " 
							+"-- Alto: "+vista.getContentPane().getSize().height 
							+"\n -- Ancho: "+vista.getContentPane().getSize().width);
	}	
	
}
