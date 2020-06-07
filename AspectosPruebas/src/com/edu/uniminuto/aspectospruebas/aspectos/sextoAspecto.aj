package com.edu.uniminuto.aspectospruebas.aspectos;

/**
 * Librerias necesarias para conocer la resolución de la pantalla
 */
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *Importacion de la clase vistaSecundariaArchivos
 *que se encuentra en el paquete vista.
 */
import com.edu.uniminuto.aspectospruebas.vista.vistaSecundariaArchivos;;

/**
 * Esta clase se encarga de ejecutar el sexto aspecto programado
 * @version 1.1.1
 * @author Julian Camilo Anzola Hincapie.
 * @author Daniel Camacho Fonseca.
 * @author Carolina Ortiz Sosa.
 * @author Johan Alexander Portilla.
 * @Copyright Este programa funciona bajo la licencia de software libre.
 */

public aspect sextoAspecto {
	
	/**
	 * Metodo encargado de ejecutar el aspecto donde se puede ver la resolucion de la pantalla
	 */
	before():
		call(void vistaSecundariaArchivos.initComponents()) {
			Toolkit t = Toolkit.getDefaultToolkit();
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			System.out.println("La resolucion de la pantalla es " + screenSize.width + "x" + screenSize.height);
		}
}
