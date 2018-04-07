package tema06;

import java.io.*;
import java.util.*;
import javax.swing.*;


/** Clase de ejemplo de Properties.
 * Pide como ejemplo un fichero del disco.
 * Guarda la carpeta donde se inició la búsqueda por última vez
 * en un fichero de configuración creado con la clase Properties
 * @author Andoni Eguíluz Morán
 * Facultad de Ingeniería - Universidad de Deusto
 */
public class EjemploProperties {

	private static String NOMBRE_FICHERO = "config.xml";
	private static Properties misProps = null;
	
	/* Crea las propiedades, cargándolos de fichero si existe
	 */
	public static void initProps() {
		misProps = new Properties();
		try {
			misProps.loadFromXML( new FileInputStream( NOMBRE_FICHERO ) );
		} catch (Exception e) { // Valores por defecto
			misProps.setProperty( "ULTIMA_CARPETA", "" );
		}
	}
	
	/** Guarda el fichero de propiedades con los valores que estén actualmente definidos
	 */
	public static void saveProps() {
		try {
			misProps.storeToXML( new PrintStream( NOMBRE_FICHERO ), "Propiedades - ejemplo" );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/** Main de prueba, genera un fichero de configuración con unas pocas propiedades
	 */
	public static void main(String[] args) {
		initProps();
			// misProps = new Properties();
			// misProps.loadFromXML( new FileInputStream( "config.xml" ) );
		JFileChooser selFichero = new JFileChooser();
		String carpeta = misProps.getProperty( "ULTIMA_CARPETA" );
		if (carpeta!=null)
			selFichero.setCurrentDirectory( new File( carpeta ) );
		int valorRetSeleccion = selFichero.showOpenDialog( null );
		if ( valorRetSeleccion == JFileChooser.APPROVE_OPTION ) {
			System.out.println( "Fichero seleccionado: " + selFichero.getSelectedFile() );
			carpeta = selFichero.getSelectedFile().getParent();
			if (carpeta!=null)
				misProps.setProperty( "ULTIMA_CARPETA", carpeta );
		} else {
			System.out.println( "Selección cancelada por el usuario" );
		}
		saveProps();
			// misProps.storeToXML( new PrintStream( "config.xml" ), "Propiedades - ejemplo" );
	}

}

