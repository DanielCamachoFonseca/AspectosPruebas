package com.edu.uniminuto.aspectospruebas.controlador;

/**
 *Importacion de la clase vistaPrincipal
 *que se encuentra en el paquete vista.
 */

import com.edu.uniminuto.aspectospruebas.vista.vistaPrincipal;

/**
 * Esta clase se encarga de ejecutar la vista principal.
 * @version 1.1.1
 * @author Julian Camilo Anzola Hincapie.
 * @author Daniel Camacho Fonseca.
 * @author Carolina Ortiz Sosa.
 * @author Johan Alexander Portilla.
 * @Copyright Este programa funciona bajo la licencia de software libre.
 */

public class main {
	
	/**
	 * Este metodo se ejecutar la aplicación.
	 * @param args Parametro estandar que se usa para ejecutar la aplicación.
	 */
	public static void main(String[] args) {
		vistaPrincipal vista = new vistaPrincipal();
		vista.setVisible (true);
	}
}










