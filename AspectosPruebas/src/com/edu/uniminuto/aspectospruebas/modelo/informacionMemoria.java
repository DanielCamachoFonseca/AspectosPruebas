package com.edu.uniminuto.aspectospruebas.modelo;

import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;
/**
 * Esta clase se encarga extraer la información solicitada
 * con respecto a la memoria
 * @version 1.1.1
 * @author Julian Camilo Anzola Hincapie.
 * @author Daniel Camacho Fonseca.
 * @author Carolina Ortiz Sosa.
 * @author Johan Alexander Portilla.
 * @Copyright Este programa funciona bajo la licencia de software libre.
 */
public class informacionMemoria {
	
	/**
	 * Este metodo se encarga de extraer el uso de la memoria.
	 * @return Retorna la informacion del uso de la memoria.
	 */
	public double extraerInformacionMemoria() {
		
        com.sun.management.OperatingSystemMXBean memoria = (com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
   
		double kb = (memoria.getTotalPhysicalMemorySize()-memoria.getFreePhysicalMemorySize()) / 1024;
		double mb = kb / 1024;
		double gb = mb / 1024;
        return gb;
	}
}
