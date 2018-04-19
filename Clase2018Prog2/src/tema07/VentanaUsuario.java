package tema07;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class VentanaUsuario extends JFrame {
	public VentanaUsuario() {
		// 1.- Inicializar la ventana
		setTitle( "Usuario 1" );
		setSize( 320, 200 );
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		// 2.- Crear sus componentes y contenedores
		// 3.- Asociar componentes a contenedores
		// 4.- Crear y asociar eventos a componentes
	}

	public static void main(String[] args) {
		VentanaUsuario v = new VentanaUsuario();
		v.setVisible( true );
	}

}
