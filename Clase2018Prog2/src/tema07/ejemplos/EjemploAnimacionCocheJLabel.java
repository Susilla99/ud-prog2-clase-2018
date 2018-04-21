package tema07.ejemplos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/** Ejemplo de animación de un JLabel en una ventana
 * @author andoni.eguiluz @ ingenieria.deusto.es
 */
public class EjemploAnimacionCocheJLabel extends JFrame {
	JPanel pCalzada;
	JLabel lCoche;
	public EjemploAnimacionCocheJLabel() {
		// Configuración de ventana
		setSize( 1000, 800 );
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		// Crear comps y conts
		// (posibilidad 1) Acceder como fichero
		// lCoche = new JLabel( new ImageIcon( "src/tema07/coche.png" ));
		// (posibilidad 2) Acceder como recurso
		lCoche = new JLabel( new ImageIcon( getClass().getResource("coche.png") ) );
		pCalzada = new JPanel();
		// Asignar layouts
		pCalzada.setLayout( null );
		// Configuración de componentes
		lCoche.setBounds( 0, 500, 300, 300 );
		// lCoche.setBorder( BorderFactory.createLineBorder( Color.red, 2 ));  // si queremos ponerle el borde
		// Añadir comps a contenedores
		pCalzada.add( lCoche ); // layout nulo
		getContentPane().add( pCalzada, BorderLayout.CENTER ); // layout por defecto - JFrame - BorderLayout 
	}
	
	/** Método principal de la clase
	 * @param args	No utilizado
	 */
	public static void main(String[] args) {
		EjemploAnimacionCocheJLabel v = new EjemploAnimacionCocheJLabel();
		v.setVisible( true );
		System.out.println( v.pCalzada.getHeight() );
		// v.dispose();
		try { Thread.sleep( 5000 );
		} catch (InterruptedException e) { }
		// v.mueveElCoche1();  // Versión 1 - movimiento horizontal
		// v.mueveElCoche2();  // Versión 2 - movimiento horizontal con velocidad decreciente
		// v.mueveElCoche3();  // Versión 3 - movimiento horizontal y vertical con rebote
		v.mueveElCoche4();  // Versión 4 - movimiento con saltos con ratón
	}

	// Versión 1 - movimiento sencillo solo en x (horizontal)
	private void mueveElCoche1() {
		int xCoche = 0;
		int xFinCoche = 700;
		int yCoche = 500;
		for (xCoche = 0; xCoche < xFinCoche; xCoche++) {
			try { Thread.sleep( 20 );
			} catch (InterruptedException e) { }
			lCoche.setLocation( xCoche, yCoche );
		}
	}
	
	// Versión 2 - Con velocidad (decreciente)
	private void mueveElCoche2() {
		double xCoche = 0;
		double xFinCoche = 700;
		double yCoche = 500;
		double velX = 500;  // px/seg
		int msgEspera = 20;  // aprox 1000/msgEspera fps
		long miTiempo = System.currentTimeMillis();
		while (velX>0) {
			try { Thread.sleep( msgEspera );
			} catch (InterruptedException e) { }
			// s = v * t
			xCoche += (velX * msgEspera / 1000.0);  // Cálculo físico del espacio en función de la velocidad
			lCoche.setLocation( (int)xCoche, (int)yCoche );
			if (velX>=0) velX -= 5;  // Decrecimiento de la velocidad
		}
		System.out.println( "Tiempo de animación: " + 
				(System.currentTimeMillis() - miTiempo));
	}

	// Versión 3 - con velocidad vertical y horizontal
	private void mueveElCoche3() {
		double xCoche = 0;
		double yCoche = 500;
		double xIniCoche = 0;
		double xFinCoche = 700;
		final int ySuelo = 500;
		double velX = 300;  // px/seg
		double velY = -500;  // px/seg
		final double G = 980.0; // px/sg2
		int msgEspera = 20;  // aprox 1000/msgEspera fps
		long miTiempo = System.currentTimeMillis();
		while (System.currentTimeMillis() - miTiempo < 10000) {  // Para a los 10 segundos
			try { Thread.sleep( msgEspera );
			} catch (InterruptedException e) { }
			// v = v + a * t
			velY += (G * msgEspera / 1000.0); 
			// s = v * t
			xCoche += (velX * msgEspera / 1000.0);
			yCoche += (velY * msgEspera / 1000.0);
			if (yCoche > ySuelo) {
				yCoche = ySuelo;
				System.out.println( velY );
				velY = -velY * 0.8;
			}
			if (xCoche > xFinCoche || xCoche < xIniCoche) {
				velX = -velX;
			}
			lCoche.setLocation( (int)xCoche, (int)yCoche );
		}
		System.out.println( "Tiempo de animación: " + (System.currentTimeMillis() - miTiempo));
	}

	// Versión 4 - Con saltos controlados por ratón
	public static double velY = 0;  // px/seg
	boolean sigueJuego = true;
	boolean pausa = false;
	// Con eventos
	// 1.- Al hacer click el coche salte
	private void mueveElCoche4() {
		// Escuchadores (normalmente se hace en el constructor)
		// 1.- Ratón  (coche salta con click)
		MouseListener ml = new MiMouseListener();
		pCalzada.addMouseListener( ml );
		// 2.- Teclado  (ventana acaba con escape)
		KeyListener kl = new MiKeyListener( this );  // Foco -> escucha el componente con foco
		pCalzada.addKeyListener( kl );
		pCalzada.requestFocus();
		// 3.- Botón
		JButton bPausa = new JButton("Pausa");
		getContentPane().add( bPausa, BorderLayout.NORTH );
		ActionListener al = new MiActionListener( this );
		bPausa.addActionListener( al );
		bPausa.addKeyListener( kl );  // Si se pulsa el botón el foco lo toma el botón
		getContentPane().validate();
		// Configuración y ejecución del bucle de juego
		double xCoche = 0;
		double yCoche = 500;
		double xIniCoche = 0;
		double xFinCoche = 700;
		final int ySuelo = 500;
		double velX = 300;  // px/seg
		final double G = 980.0; // px/sg2
		int msgEspera = 20;  // aprox 1000/msgEspera fps
		long miTiempo = System.currentTimeMillis();
		// TODO Si se cierra la ventana con la x el programa nunca acaba ¿cómo se podría hacer para que acabara...?  
		while (sigueJuego) {
			try { Thread.sleep( msgEspera );
			} catch (InterruptedException e) { }
			if (pausa) {
				miTiempo = System.currentTimeMillis();
			} else {
				// v = v + a * t
				velY += (G * msgEspera / 1000.0); 
				// s = v * t
				xCoche += (velX * msgEspera / 1000.0);
				yCoche += (velY * msgEspera / 1000.0);
				if (yCoche > ySuelo) {
					yCoche = ySuelo;
					velY = -velY * 0.8;
				}
				if (xCoche > xFinCoche || xCoche < xIniCoche) {
					velX = -velX;
				}
				lCoche.setLocation( (int)xCoche, (int)yCoche );
			}
		}
		System.out.println( "Tiempo de animación: " + (System.currentTimeMillis() - miTiempo));
		dispose();
	}
	
	
}

class MiMouseListener extends MouseAdapter {
	@Override
	public void mouseClicked(MouseEvent arg0) {
		EjemploAnimacionCocheJLabel.velY += -300;  // Suma -300 a la velocidad vertical
	}
}

class MiKeyListener extends KeyAdapter {
	EjemploAnimacionCocheJLabel v;
	public MiKeyListener(EjemploAnimacionCocheJLabel v) {
		this.v = v;
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		if (arg0.getKeyCode() == KeyEvent.VK_ESCAPE)
			v.sigueJuego = false;
	}
}

class MiActionListener implements ActionListener {
	EjemploAnimacionCocheJLabel v;
	public MiActionListener(EjemploAnimacionCocheJLabel v) {
		this.v = v;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		v.pausa = !v.pausa;  // invertir true-false
	}
}