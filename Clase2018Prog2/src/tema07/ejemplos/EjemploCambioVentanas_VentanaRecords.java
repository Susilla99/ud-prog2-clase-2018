package tema07.ejemplos;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EjemploCambioVentanas_VentanaRecords extends JFrame {
	JList<String> lRecords;
	JFrame ventanaAnterior;
	public EjemploCambioVentanas_VentanaRecords( JFrame v ) {
		ventanaAnterior = v;
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setSize( 400, 300 );
		JLabel lTitulo = new JLabel( "TOP TEN" );
		lTitulo.setHorizontalAlignment( JLabel.CENTER );
		lRecords = new JList<String>();
		JButton bVolver = new JButton( "Volver" );
		JPanel pBotonera = new JPanel();
		getContentPane().add( lTitulo, BorderLayout.NORTH );
		getContentPane().add( lRecords, BorderLayout.CENTER );
		getContentPane().add( pBotonera, BorderLayout.SOUTH );
		pBotonera.add( bVolver );
		bVolver.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible( false );
				ventanaAnterior.setVisible( true );
			}
		});
	}
	
	public static void main(String[] args) {
		EjemploCambioVentanas_VentanaRecords v = new EjemploCambioVentanas_VentanaRecords( null );
		v.setVisible( true );
	}
}
