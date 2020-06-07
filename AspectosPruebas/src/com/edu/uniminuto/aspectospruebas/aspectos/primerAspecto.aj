package com.edu.uniminuto.aspectospruebas.aspectos;

/**
 *Importacion de las librerias necesarias para saber
 *cuando se inicie llame el metodo de recibir peticion
 *de la clase controlador.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *Importacion de la clase controlador
 *que se encuentra en el paquete controlador.
 */
import com.edu.uniminuto.aspectospruebas.controlador.controlador;

/**
 * Esta clase se encarga de ejecutar el primer aspecto programado
 * @version 1.1.1
 * @author Julian Camilo Anzola Hincapie.
 * @author Daniel Camacho Fonseca.
 * @author Carolina Ortiz Sosa.
 * @author Johan Alexander Portilla.
 * @Copyright Este programa funciona bajo la licencia de software libre.
 */

public aspect primerAspecto {
	
	/**
	 * Atributo donde se almacena el a�o de ejecuci�n
	 */
	private int a�o;
	
	/**
	 * Atributo donde se almacena el mes de ejecuci�n
	 */
	private int mes;
    
    /**
	 * Atributo donde se almacena el dia de ejecuci�n
	 */
	private int dia;
	
    /**
     * Atributo que carga la fecha del sistema
     */
	private Calendar fecha;
    
    /**
     * Constructor de la clase
     */
	public primerAspecto() {
		
		fecha = new GregorianCalendar();
		this.a�o = fecha.get(Calendar.YEAR);
	    this.mes = fecha.get(Calendar.MONTH);
	    this.dia = fecha.get(Calendar.DAY_OF_MONTH);
	}
	
	/**
	 * Instrucci�n encargada de ejecutar el aspecto cuando se llama el metodo de recibirPeticion de la
	 * clase controlador
	 */
	pointcut greeting(): execution(* controlador.recibirPeticion(..));
	
	/**
	 * Ejecuci�n del aspecto donde se mostrara la fecha de la ejecuci�n del metodo recibirPeticion
	 * de la clase controlador
	 */
	after() returning(): greeting(){
		System.out.println("El metodo recibirPeticion de la clase controlador se llamo el dia " + dia+" del mes "+(mes+1)+" del a�o "+a�o);
	}	
}
