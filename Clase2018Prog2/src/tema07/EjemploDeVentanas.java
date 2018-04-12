package tema07;

import javax.swing.*;
import java.awt.*;

public class EjemploDeVentanas {

	public static void main(String[] args) {
		JFrame ventana = new JFrame();
		ventana.setTitle( "Mi primera ventana" );
		ventana.setSize( 400, 300 );
		ventana.setResizable( true );
		JButton boton = new JButton( "Púlsame!" );
		ventana.add( boton );
		ventana.setLayout( null );
		boton.setSize( 280, 100 );
		boton.setLocation( 100, 100 );
		
		ventana.setVisible( true );
		System.out.println( "final" );
	}

}
