package com.edu.uniminuto.aspectospruebas.vista;

/**
 *Importacion de las librerias necesarias
 *para la ejecución de la vista encargada
 *de presentar el consumo de la memoria.
 */
import java.awt.BorderLayout;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.time.Second;
import org.jfree.data.time.DynamicTimeSeriesCollection;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *Importacion de la clase controlador
 *que se encuentra en el paquete controlador.
 */
import com.edu.uniminuto.aspectospruebas.controlador.controlador;

/**
 * Esta clase se encarga de presentar el consumo de la memoria
 * @version 1.1.1
 * @author Julian Camilo Anzola Hincapie.
 * @author Daniel Camacho Fonseca.
 * @author Carolina Ortiz Sosa.
 * @author Johan Alexander Portilla.
 * @Copyright Este programa funciona bajo la licencia de software libre.
 */
public class vistaSecundariaMemoria extends JFrame {
 
	/**
	 * Constructor de la clase
	 */
	public vistaSecundariaMemoria() {
		
		this.setSize(new Dimension(705, 470));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		add(new PanelGraphicaEnTiempoReal());
	}
	
	/**
	 * Esta clase se encarga de cargar la grafica que presentara el consumo de la memoria
	 * @version 1.1.1
	 * @author Julian Camilo Anzola Hincapie.
	 * @author Daniel Camacho Fonseca.
	 * @author Carolina Ortiz Sosa.
	 * @author Johan Alexander Portilla.
	 * @Copyright Este programa funciona bajo la licencia de software libre.
	 */
	private static class PanelGraphicaEnTiempoReal extends JPanel implements ActionListener {
		
		/**
		 * Atributo que carga el dinamismo de la grafica.
		 */
		private DynamicTimeSeriesCollection contenidoSerieDinamica;
		
		/**
		 * Atributo que carga la grafica donde se presentara el consumo de la memoria.
		 */
		private JFreeChart graphicaDeTiempo;
		
		/**
		 * Atributo que carga el cronometro que presenta la información cada segundo.
		 */
		private Timer cronometro;
		
		/**
		 * Atributo que carga el consumo de la memoria.
		 */
		private double memoria;
		
		/**
		 * Atributo que carga el segundo en el cual se encuentra el consumo de la memoria.
		 */
		private int segundo;
		
		/**
		 * Atributo que carga el minuto en el cual se encuentra el consumo de la memoria.
		 */
		private int minuto;
		
		/**
		 * Atributo que carga la hora en la cual se encuentra el consumo de la memoria.
		 */
		private int hora;
		
		/**
		 * Atributo que carga el dia en el cual se encuentra el consumo de la memoria.
		 */
		private int dia;
		
		/**
		 * Atributo que carga el mes en el cual se encuentra el consumo de la memoria.
		 */
		private int mes;
		
		/**
		 * Atributo que carga el año en el cual se encuentra el consumo de la memoria.
		 */
		private int año;
		
		/**
		 * Atributo que carga el indice donde se encuentra la serie de la grafica.
		 */
		private int indiceSerie;
		
		/**
		 * Atributo que carga el nombre de la serie.
		 */
		private String nombreDeLaSerie;
		
		/**
		 * Atributo que carga la respuesta del consumo de la memoria.
		 */
		private controlador respuestaMemoria;
 
		/**
		 * Constructor de la clase.
		 */
		public PanelGraphicaEnTiempoReal() {
	
			cronometro=new Timer(200,this);
			contenidoSerieDinamica = new DynamicTimeSeriesCollection(1,getCantidadPorSerie(),enSegundos());//crea el contenido de la serie dinamica
			contenidoSerieDinamica.setTimeBase(new Second(segundo=0,minuto=0,hora=0,dia=1,mes=1,año=2020));//pone el primer instante
			contenidoSerieDinamica.addSeries(valoresDeLaSerie(), indiceSerie=0,nombreDeLaSerie="MEMORIA");//agrega una serie
			graphicaDeTiempo = ChartFactory.createTimeSeriesChart("CONSUMO DE MEMORIA",null,"CONSUMO EN GB",
							   contenidoSerieDinamica,true,false,false);//crea una grafica de tiempo
			ChartPanel panelDeLaGraphica = new ChartPanel(graphicaDeTiempo);//crea un panel para graficas
			add(panelDeLaGraphica);
			
			respuestaMemoria=new controlador();
			cronometro.start();
		}
		
		/**
		 * Este metodo caga los valores de la serie de manera aleatoria.
		 * @return Retorna el valor de la serie.
		 */
		private float[] valoresDeLaSerie() {

			float[] respuesta = new float[getCantidadPorSerie()];
			Random creadorDeAleatorios = new Random();
			for (int i = 0; i < respuesta.length; i++) {
				respuesta[i]=creadorDeAleatorios.nextFloat();//crea un aleatorio;
			}
			return respuesta;
		}
		
		@Override
		
		/**
	     * Este metodo se encarga de cargar los datos ejecutar constantemente la grafica para
	     * poder ver los datos en tiempo real.
	     * @param e Evento que desencadena la ejecucion de la grafica en tiempo real.
	     */
		public void actionPerformed(ActionEvent e) {
			
			memoria=respuestaMemoria.recibirPeticioMemoria();
			contenidoSerieDinamica.advanceTime();//avansa el tiempo
			contenidoSerieDinamica.appendData(new float[]{(float) memoria});//agrega un aleatorio
		}
		
		/**
		 * Este metodo aumenta cada segundo.
		 * @return Retorna el segundo en el cual se encuentra la grafica.
		 */
		private Second enSegundos() {
			return new Second();
		}
		
		/**
		 * Este metodo carga la velocidad en la cual se desea ver la grafica.
		 * @return Retorna la velocidad de la grafica.
		 */
		public int getCantidadPorSerie() {
			return 400;
		}
	}
}
