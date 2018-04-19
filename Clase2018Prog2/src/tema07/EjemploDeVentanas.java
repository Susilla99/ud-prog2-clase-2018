package tema07;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/** Nuestras primeras pruebas con ventanas 2018
 */
public class EjemploDeVentanas {

	public static void main(String[] args) {
		// Definici�n visual de la ventana y componentes
		JFrame ventana = new JFrame();
		ventana.setTitle( "Mi primera ventana" );
		ventana.setSize( 400, 300 );
		ventana.setResizable( true );
		JButton boton = new JButton( "P�lsame!" );
		ventana.add( boton );
		ventana.setLayout( null );
		boton.setSize( 280, 100 );
		boton.setLocation( 100, 100 );
		
		// Gesti�n de eventos
		ActionListener al = new MiActionListener2( boton );
		boton.addActionListener( al );
		MouseListener ml = new MiMouseListener2();
		boton.addMouseListener( ml );
		
		ventana.setVisible( true );
		System.out.println( "final" );
	}

}

/** Escuchador de bot�n de prueba
 */
class MiActionListener2 implements ActionListener {
	JButton b;
	/** Para acceder al bot�n se puede recibir en la construcci�n y guardar como atributo
	 * @param b	Bot�n sobre el que actuar
	 */
	public MiActionListener2( JButton b ) {
		this.b = b;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// Manera 1 de acceder: bot�n recibido previamente
		System.out.println( b.getText() );  
		b.setForeground(Color.red);
		b.setBackground(Color.red);
		// Manera 2: a trav�s del par�metro del gestor de eventos (ActionEvent)
		if (e.getSource() instanceof JButton) {
			((JButton)(e.getSource())).setBackground( Color.blue );  // a) Hacerlo directamente
			JButton b2 = (JButton) e.getSource();  // b) guardarlo en variable y hacerlo despu�s
			b2.setBackground( Color.magenta );
		}
		// if (e.getSource()==b)  // As� se comparar�a con un bot�n en particular si hay varios
		System.out.println( b.toString() );
	}
}

/** Escuchador de rat�n de prueba
 */
class MiMouseListener2 extends MouseAdapter {

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println( "click");
		// calculoGordo();  // Esto va a dar problemas... �por qu�?
	}
	
		private void calculoGordo() {
			long inicio = System.currentTimeMillis();
			while (System.currentTimeMillis()-inicio < 10000) {
				System.out.println( "Calculando..." );
			}
		}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println( "press"  + e.getX() + "," + e.getY() );
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println( "release " + e.getX() + "," + e.getY() );
	}

}
