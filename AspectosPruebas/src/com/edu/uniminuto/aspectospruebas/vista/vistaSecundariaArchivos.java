package com.edu.uniminuto.aspectospruebas.vista;

/**
 *Importacion de las librerias necesarias
 *para la ejecución de la vista encargada
 *de presentar el tamaño de los archivos.
 */
import java.io.File;
import java.text.DecimalFormat;
import javax.swing.table.DefaultTableModel;

/**
 *Importacion de la clase controlador
 *que se encuentra en el paquete controlador.
 */
import com.edu.uniminuto.aspectospruebas.controlador.controlador;

/**
 * Esta clase se encarga de presentar el tamaño de los archivos
 * @version 1.1.1
 * @author Julian Camilo Anzola Hincapie.
 * @author Daniel Camacho Fonseca.
 * @author Carolina Ortiz Sosa.
 * @author Johan Alexander Portilla.
 * @Copyright Este programa funciona bajo la licencia de software libre.
 */
public class vistaSecundariaArchivos extends javax.swing.JFrame {
	
	/**
	 * Atributo que carga el boton encargado de presentar el tamaño de los archivos.
	 */
	private javax.swing.JButton jButton1;
	
	/**
	 * Atributo que carga el título encargado de describir el nombre de la sección.
	 */
    private javax.swing.JLabel jLabel1;
    
    /**
     * Atributo encargado de cargar el scroll que servira para visualizar el tamaño de todos los archivos.
     */
    private javax.swing.JScrollPane jScrollPane2;
    
    /**
     * Atributo encargado de cargar los datos en una tabla.
     */
    private javax.swing.JTable jTable1;
    
    /**
     * Atributo encargado de cargar las caracteristicas de la tabla.
     */
    private DefaultTableModel modelo;
    
    /**
     * Constructor de la clase.
     */
    public vistaSecundariaArchivos() {
        initComponents();
        modelo = new DefaultTableModel();
    	modelo.addColumn("NOMBRE");
    	modelo.addColumn("TAMAÑO");
    	jTable1.setModel(modelo);
    }

    /**
     * Este metodo se encarga de cargar el formularo de la vista
     * donde se presenta el tamaño de los archivos.
     */                        
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("INFORMACIÓN DE LOS ARCHIVOS");

        jButton1.setText("VISUALIZAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "NOMBRE", "TAMAÑO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }                       
    
    /**
     * Este metodo ejecuta la visualización del tamaño de los archivos.
     * @param evt Evento que desencadena la busqueda y presentación del tamaño de los archivos.
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	
    	File archivos=new File("C:/");
    	float[] respuesta=new float[0];
    	controlador controlador=new controlador();
    	String[] listaArchivos=archivos.list();
    	
    	for(int i=1;i<20;i++) {
    		
    		String ruta="C:/";
        	ruta=ruta+listaArchivos[i];
            respuesta=controlador.recibirPeticion(3,ruta);
            
            DecimalFormat formateador = new DecimalFormat("0.0");
        	Object[] linea = new Object[2];
        	linea[0] = listaArchivos[i];
        	System.out.println(respuesta[0]);
        	
        	if(respuesta[0]!=0) {
        		linea[1] =  formateador.format(respuesta[0]);
        	}else {
        		linea[1] =  "No se puede acceder a la información";
        	}
        	modelo.addRow(linea);
        	jTable1.setModel(modelo);
    	}
    }                                        
                           
}
