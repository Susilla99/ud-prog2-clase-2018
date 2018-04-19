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
		setIconImage( new ImageIcon( getClass().getResource("UD-icon.png" )).getImage() );  // Cambiar el icono de la ventana (ojo - tiene que tener el tamaño apropiado)
		// 2.- Crear sus componentes y contenedores
		JPanel pInferior = new JPanel();
		JButton bCancelar = new JButton( "Cancelar" );
		JButton bAceptar = new JButton( "Aceptar" );
		JLabel lFoto = new JLabel( new ImageIcon( "src/tema07/coche.png" ) );
		JTextField tfNick = new JTextField( "nick", 10 );
		JTextArea taCV = new JTextArea( 5, 20 );
		// 2b.- Definir layouts
		this.setLayout( new BorderLayout() );  // Por defecto es así
		pInferior.setLayout( new FlowLayout() ); // Por defecto es así
		// 2c.- Confirgurar componentes
		lFoto.setSize( 100, 50 );
		// 3.- Asociar componentes a contenedores
		this.add( tfNick, BorderLayout.WEST );
		JScrollPane spCV = new JScrollPane( taCV );
		this.add( spCV , BorderLayout.CENTER );
		this.add( lFoto, BorderLayout.EAST );
		this.add( pInferior, BorderLayout.SOUTH );
		pInferior.add( bCancelar );
		pInferior.add( bAceptar );
		// 4.- Crear y asociar eventos a componentes
	}

	public static void main(String[] args) {
		VentanaUsuario v = new VentanaUsuario();
		v.setVisible( true );
	}

}
