package com.edu.uniminuto.aspectospruebas.modelo;

/**
 *Importacion de las librerias necesarias
 *para la extracci�n de la informaci�n del disco.
 */
import java.io.File;
import java.text.DecimalFormat;

/**
 * Esta clase se encarga extraer la informaci�n solicitada
 * con respecto al disco
 * @version 1.1.1
 * @author Julian Camilo Anzola Hincapie.
 * @author Daniel Camacho Fonseca.
 * @author Carolina Ortiz Sosa.
 * @author Johan Alexander Portilla.
 * @Copyright Este programa funciona bajo la licencia de software libre.
 */
public class informacionDisco {
	
	/**
	 * Atributo donde se almacena el tama�o del disco
	 */
	private float[] tamano;
	
	/**
	 * Atributo donde se almacena el tama�o de los archivos
	 */
    private float espacioUtilizado;
    
    /**
     * Atributo donde se almacena la ruta donde se encuentra los archivos.
     */
    private static File ruta;
	
    /**
     * Constructor de la clase.
     * @param ruta Ruta donde se encuentra los archivos.
     */
	public informacionDisco(String ruta) {
		this.tamano=new float[8];
		this.espacioUtilizado = 0;
		this.ruta = new File(ruta);
	}

	/**
	 * Este metodo se encarga de extraer la informacion del disco, como el tama�o total
	 * y el tama�a usado.
	 * @return Retorna la informacion del tama�o total y el tama�o usado
	 */
	public float[] extraerInformacionDisco() {
		
		File [] unidades = File.listRoots();
		int contador=0;
		double kb = 0;
		double mb = 0;
		double gb = 0;
		
        for(File f : unidades){
        	if(contador<8) {
        		
        		kb = f.getTotalSpace() / 1024;
        		mb = kb / 1024;
        		gb = mb / 1024;
        		this.tamano[contador]=Math.round(gb);
        		contador=contador+1;
        		
        		kb = 0;
        		mb = 0;
        		gb = 0;
        		
        		kb = f.getFreeSpace() / 1024;
        		mb = kb / 1024;
        		gb = mb / 1024;
        		this.tamano[contador]=Math.round(gb);
        		contador=contador+1;
        	}
        }
        return this.tamano;
	}

	/**
	 * Este metodo se encarga de extraer la informaci�n del disco, como el total
	 * de disco da�ado.
	 * @return Retorna la informacion del total del disco da�ado.
	 */
	public float[] extraerInformacionDiscoDa�ado() {
		
		float[] respuesta=new float[8];
		float[] discoDanado=new float[1];
		
		respuesta=this.extraerInformacionDisco();
		discoDanado[0]=1000-(respuesta[0]+respuesta[2]);
		
		return discoDanado;
	}
	
	/**
	 * Este metodo se encarga de ejecutar la recursividad que se encargara
	 * de extraer el tama�o de los archivos.
	 * @return Retorna el tama�o de los archivos.
	 */
	public float[] tamanoArchivos() {
		this.calcularArchivos(this.ruta);
		float[] resultado=new float[1];
        resultado[0]=this.espacioUtilizado;
        return resultado;
	}
	
	/**
	 * Este metodo extrae la informacion del tama�o de los archivos dentro del disco
	 * @param rutaArchivo Ruta donde se encuentra el archivo
	 */
	private void calcularArchivos(File rutaArchivo){
        File[] ListFiles = rutaArchivo.listFiles();
        if(ListFiles!=null) {
        	int DirLength = ListFiles.length;
            for(int x = 0;x < DirLength;x ++){
                if(ListFiles[x].isFile()){
                	espacioUtilizado += ((ListFiles[x].length()/1024.0)/1024.0);
                }else{
                    this.calcularArchivos(ListFiles[x]);
                }
            }
        }
    }
}
