package com.edu.uniminuto.aspectospruebas.vista;

/**
 *Importacion de las librerias necesarias
 *para la ejecución de la vista donde se presenta las
 *opciones del sistema.
 */
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *Importacion de la clase controlador
 *que se encuentra en el paquete controlador.
 */
import com.edu.uniminuto.aspectospruebas.controlador.controlador;

/**
 * Esta clase se encarga de presentar las opciones 
 * que tiene el sistema
 * @version 1.1.1
 * @author Julian Camilo Anzola Hincapie.
 * @author Daniel Camacho Fonseca.
 * @author Carolina Ortiz Sosa.
 * @author Johan Alexander Portilla.
 * @Copyright Este programa funciona bajo la licencia de software libre.
 */
public class vistaPrincipal extends javax.swing.JFrame {
	
	/**
	 * Atributo donde se carga la grafica que presenta la información del disco.
	 */
	private JFreeChart Grafica;
	
	/**
	 * Atributo donde se cargara la información del disco.
	 */
	private DefaultCategoryDataset Datos=new DefaultCategoryDataset();
	
	/**
	 * Atributo que carga el buton encargado de presentar la informacion del disco.
	 */
	private javax.swing.JButton jButton1;
	
	/**
	 * Atributo que carga el boton encargado de presentar la informacion de los archivos.
	 */
    private javax.swing.JButton jButton2;
    
    /**
     * Atributo que carga el boton encargado de presentar la informacion de la memoria.
     */
    private javax.swing.JButton jButton3;
    
    /**
     * Atributo encargado de cargar el título del proyecto.
     */
    private javax.swing.JLabel jLabel1;
    
	/**
	 * Constructor de la clase.
	 */
    public vistaPrincipal() {
        initComponents();
    }     
    
    /**
     * Este metodo se encarga de cargar el formularo de la vista
     * donde se presenta las opciones que tiene el sistema.
     */
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Practico 3 - 1");

        jButton1.setText("VER INFORMACIÓN DEL DISCO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("VER INFORMACIÓN DE ARCHIVOS");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setText("VER INFORMACIÓN DE LA CPU");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(30, 30, 30)
                .addComponent(jButton3)
                .addGap(44, 44, 44)
                .addComponent(jButton2)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }                        
    
    /**
     * Este metodo ejecuta la acción de presentar la información del disco.
     * @param evt Evento que desencadena la busqueda y presentación de la información del disco.
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {   
    	
    	controlador controlador=new controlador();
    	float[] resultado=new float[8];
    	float[] resultadoDanado=new float[1];
    	
    	resultado=controlador.recibirPeticion(1,"VACIO");
    	resultadoDanado=controlador.recibirPeticion(2,"VACIO");
    	
    	Datos.addValue(resultado[0], "Total Disco C", "Total");
    	Datos.addValue(resultado[1], "Uso Disco C", "Total");
        Datos.addValue(resultadoDanado[0], "Total Dañado", "Total");
        
        Grafica = ChartFactory.createBarChart("INFORMACIÓN DEL DISCO","USO DEL DISCO", "GB", Datos,PlotOrientation.VERTICAL, true, true, true);
    	ChartPanel Panel = new ChartPanel(Grafica);
    	
    	JFrame Ventana = new JFrame("INFORMACIÓN DEL CONSUMO");
    	Ventana.getContentPane().add(Panel);
    	Ventana.pack();
    	Ventana.setVisible(true);
    	Ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }                                        

    /**
     * Este metodo ejecuta la acción de presentar la informacion del tamaño de los archivos
     * @param evt Evento que desencadena la busqueda y presentacion del tamaño de los archivos
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) { 
    	
    	this.setVisible(false);
        vistaSecundariaArchivos vista=new vistaSecundariaArchivos();
        vista.setVisible(true);
    }
    
    /**
     * Este metodo ejecuta la acción de presentar la informacion de la memoria.
     * @param evt Evento que desencadena la busqueda y presentación del consumo de la memoria.
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {   
    	
    	this.setVisible(false);
        vistaSecundariaMemoria vista=new vistaSecundariaMemoria();
        vista.setVisible(true);
    }
                                       
}
