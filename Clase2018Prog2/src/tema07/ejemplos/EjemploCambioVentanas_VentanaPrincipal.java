package tema07.ejemplos;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class EjemploCambioVentanas_VentanaPrincipal extends JFrame {

	public EjemploCambioVentanas_VentanaPrincipal() {
		// Configuración
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setSize( 600, 450 );
		setTitle( "Menú principal" );
		// Crear componentes y contenedores
		JButton bRecords = new JButton( "Records" );
		JButton bConfig = new JButton( "Configuración" );
		JButton bJugar = new JButton( "Jugar!" );
		// Configurar layouts y formato
		getContentPane().setLayout( new GridLayout( 3, 1 ) );
		// bRecords.setIcon( ... );
		// Asignar componentes a contenedores
		getContentPane().add( bRecords );
		getContentPane().add( bConfig );
		getContentPane().add( bJugar );
		// Gestión de eventos
		bConfig.addActionListener( new Boton1Action() );
		bRecords.addActionListener(
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// System.out.println( "Pulsado records");
					EjemploCambioVentanas_VentanaRecords v = new EjemploCambioVentanas_VentanaRecords( EjemploCambioVentanas_VentanaPrincipal.this );
					v.setLocation( getLocation() );
					v.setVisible( true );
					EjemploCambioVentanas_VentanaPrincipal.this.setVisible( false );
				}
			}
		);
		bJugar.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println( "Pulsado Jugar");
				}
			}
		);
		
		ActionListener escBotones = new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent e ) {
				System.out.println( "Pulsado botón " + e.getSource() );
				if (e.getSource()==bConfig) {
					// ..
				} else {
					// ..
				}
			}
		};
		bConfig.addActionListener( escBotones );
		bJugar.addActionListener( escBotones );
		bRecords.addActionListener( escBotones );
		WindowAdapter prueba = new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
			}
		};
		addWindowListener( new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
			}
		});
		/*
		addWindowListener(
			new WindowListener() {
				@Override
				public void windowOpened(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void windowClosing(WindowEvent e) {
					System.out.println( "Adiós");
					// VentanaEjemploPrincipal nueva = new VentanaEjemploPrincipal();
					// nueva.setVisible( true );
				}

				@Override
				public void windowClosed(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void windowIconified(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void windowDeiconified(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void windowActivated(WindowEvent e) {
					// TODO Auto-generated method stub
					System.out.println( "Activada");
				}

				@Override
				public void windowDeactivated(WindowEvent e) {
					// TODO Auto-generated method stub
					System.out.println( "Desactivada");
				}
				
			}
		);
		*/
	}
	
	private class Boton1Action implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println( "Pulsado Config");
		}
	}
	
	public static void main(String[] args) {
		EjemploCambioVentanas_VentanaPrincipal v = new EjemploCambioVentanas_VentanaPrincipal();
		v.setVisible( true );
	}

}
