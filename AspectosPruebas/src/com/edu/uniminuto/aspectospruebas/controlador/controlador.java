package com.edu.uniminuto.aspectospruebas.controlador;

/**
 *Importacion de la clase informacionDisco
 *que se encuentra en el paquete modelo.
 */

import com.edu.uniminuto.aspectospruebas.modelo.informacionDisco;

/**
 *Importacion de la clase informacionMemoria
 *que se encuentra en el paquete modelo.
 */

import com.edu.uniminuto.aspectospruebas.modelo.informacionMemoria;

/**
 * Esta clase se encarga de servir como controlador entre las clases de 
 * informacionDisco y informacionMemoria, se encarga de dirigir el trafico de las solicitudes.
 * @version 1.1.1
 * @author Julian Camilo Anzola Hincapie.
 * @author Daniel Camacho Fonseca.
 * @author Carolina Ortiz Sosa.
 * @author Johan Alexander Portilla.
 * @Copyright Este programa funciona bajo la licencia de software libre.
 */

public class controlador {
	
	/**
	 * Este metodo se encarga de dirigir las solicitudes realizadas a la clase informacionDisco.
	 * @param operacion Es el tipo de operacion que se quiere realizar.
	 * @param ruta Ruta la cual sirve para extraer la información solicitada.
	 * @return Retorna las respuestas de las solicitudes realizadas.
	 */
	
	public float[] recibirPeticion(int operacion, String ruta) {
		return this.solicitarInformacionDisco(operacion,ruta);
	}
	
	/**
	 * Este metodo se encarga de dirigir las solicitudes realizadas a la clase informacionMemoria.
	 * @return Retorna las respuestas de las solicitudes realizadas.
	 */
	
	public double recibirPeticioMemoria() {
		return this.solicitarInformacionMemoria();
	}
	
	/**
	 * Este metodo se encarga de solicitar la informacion de la memoria.
	 * @return Informacion solicitada.
	 */
	private double solicitarInformacionMemoria() {
		informacionMemoria memoria=new informacionMemoria();
		return memoria.extraerInformacionMemoria();
	}
	
	/**
	 * Este metodo se encarga de realizar la peticion de la informacion del disco.
	 * @param operacion Tipo de información que se desea extraer
	 * @param ruta Ruta donde se encuentra la informacion a extraer
	 * @return Retorna la información solicitada
	 */
	private float[] solicitarInformacionDisco(int operacion,String ruta) {
		if(operacion==1) {
			informacionDisco informacion=new informacionDisco("VACIO");
			return informacion.extraerInformacionDisco();
		}else {
			if(operacion==2) {
				informacionDisco informacion=new informacionDisco("VACIO");
				return informacion.extraerInformacionDiscoDañado();
			}else {
				if(operacion==3) {
					informacionDisco informacion=new informacionDisco(ruta);
					return informacion.tamanoArchivos();
				}
			}
		}
		return null;
	}
}
