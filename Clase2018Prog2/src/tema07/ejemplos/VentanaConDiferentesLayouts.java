package tema07.ejemplos;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/** Ejemplo de layouts sencillos cambiando el layout "en caliente" con botones
 * @author andoni.eguiluz @ ingenieria.deusto.es
 */
public class VentanaConDiferentesLayouts extends JFrame {
	
	public VentanaConDiferentesLayouts() {
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		JButton boton1 = new JButton("BorderLayout");
		JButton boton2 = new JButton("FlowLayout");
		JButton boton3 = new JButton("GridLayout");
		JButton boton4 = new JButton("BoxLayout V");
		JButton boton5 = new JButton("BoxLayout H");

		getContentPane().setLayout(new GridLayout(3,2));  // Empieza con GridLayout
		// this.setLayout ... esto ser�a lo mismo. En el JFrame la ventana hace referencia a su panel principal (getContentPane())
		
		getContentPane().add(boton1);
		getContentPane().add(boton2);
		getContentPane().add(boton3);
		getContentPane().add(boton4);
		getContentPane().add(boton5);

		this.setSize(800,600);
		
		boton1.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().setLayout( new BorderLayout() );
				// El BorderLayout necesita que los componentes se identifiquen en posici�n
				getContentPane().add( boton1, BorderLayout.NORTH );
				getContentPane().add( boton2, BorderLayout.WEST );
				getContentPane().add( boton3, BorderLayout.CENTER );
				getContentPane().add( boton4, BorderLayout.EAST );
				getContentPane().add( boton5, BorderLayout.SOUTH );
				getContentPane().revalidate();  // El cambio de estructura en caliente necesita un revalidate()
			}
		});
		boton2.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().setLayout( new FlowLayout() );
				getContentPane().revalidate();  // El cambio de estructura en caliente necesita un revalidate()
			}
		});
		boton3.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().setLayout(new GridLayout(3,2));
				getContentPane().revalidate();  // El cambio de estructura en caliente necesita un revalidate()
			}
		});
		boton4.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().setLayout( new BoxLayout(getContentPane(), BoxLayout.Y_AXIS) );
				getContentPane().revalidate();  // El cambio de estructura en caliente necesita un revalidate()
			}
		});
		boton5.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().setLayout( new BoxLayout(getContentPane(), BoxLayout.X_AXIS) );
				getContentPane().revalidate();  // El cambio de estructura en caliente necesita un revalidate()
			}
		});
	}
	public static void main(String[] args)
	{
		JFrame v = new VentanaConDiferentesLayouts();
		v.setVisible(true);
	}
}
