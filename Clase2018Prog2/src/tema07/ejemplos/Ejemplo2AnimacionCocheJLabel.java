package tema07.ejemplos;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;

import javax.swing.*;

import tema07.utils.JLabelGraficoAjustado;

public class Ejemplo2AnimacionCocheJLabel extends JFrame {
	private static final long serialVersionUID = 1L;
	JLabel lCoche;
	JPanel pEscenario;
	public Ejemplo2AnimacionCocheJLabel() {
		setSize( 1000, 800 );
		setDefaultCloseOperation( JFrame.HIDE_ON_CLOSE );
		lCoche = new JLabelGraficoAjustado( "src/tema07/ejemplos/coche.png", 200, 200 );
		pEscenario = new JPanel();
		pEscenario.setLayout(null);
		lCoche.setBounds( 0, 500, 300, 300 );
		pEscenario.add( lCoche );
		getContentPane().add( pEscenario, BorderLayout.CENTER );
	}
	
	private class Coche {
		double x,y,velX,velY;
		JLabel grafico;
		static final double G = 980.0;  // px/sg2
		Coche(JLabel grafico) { this.grafico = grafico; }
		void setPos( double x, double y ) { this.x = x; this.y = y; }
		void setVel( double velX, double velY ) { this.velX = velX; this.velY = velY; }
		void actualizaFisica(double tiempo) {
			velY += (G * tiempo);
			x += (velX * tiempo);
			y += (velY * tiempo);
		}
		void actualizaGrafico() { grafico.setLocation( (int)x, (int)y ); }
	}

	// Con solo un % de restitucion,
	// Añadiendo <Esc> para acabar y click para saltar (si está abajo)
	// Añadiendo botón de pausa
	// Añadiendo cierre de bucle de juego cuando se cierra la ventana
		boolean sigueJuego = true;
		boolean pulsadoSalto = true;
		boolean pausa = false;
	private void mueveElCoche5() {
		Coche c = new Coche(lCoche);
		// Añade eventos
		// 1. Escuchador de botón
		JButton bPausa = new JButton("Pausa");
		getContentPane().add( bPausa, BorderLayout.NORTH );
		ActionListener al = new MiActionListener();
		bPausa.addActionListener( al );
		// 2. Escuchador de teclado
		KeyListener kl = new MiKeyListener();
		pEscenario.addKeyListener( kl );
		bPausa.addKeyListener( kl );
		// 3. Escuchador de ratón
		MouseListener ml = new MiMouseListener();
		pEscenario.addMouseListener( ml );
		pEscenario.requestFocus();  // Para que el foco de teclado esté en el panel
		// 4. Escuchador de ventana
		WindowListener wl = new MiWindowListener();
		addWindowListener( wl );
		// 5. Escuchador de movimiento de ratón (sigue el coche al ratón en horizontal)
		MouseMotionListener mml = (new MouseMotionListener() {
			Coche c;
			MouseMotionListener setCoche( Coche c) { this.c = c; return this; }
			@Override
			public void mouseMoved(MouseEvent e) {
				System.out.println( e.getX() );
				c.velX = e.getX()-150 - c.x;
				if (c.velX > 300) c.velX = 300;
				else if (c.velX < -300) c.velX = -300;   // Limitar la velocidad horizontal
			}
			@Override
			public void mouseDragged(MouseEvent e) {
			}
		}).setCoche( c );
		pEscenario.addMouseMotionListener( mml );
		// Bucle de juego:
		c.setPos( 0,  500 );
		c.setVel( 100, -1000 );
		double limX = 750;
		double limY = 500;
		int msgEspera = 1;
		long milis = System.currentTimeMillis();
		while (sigueJuego) {  // Va rebotando con vel y y gravedad
			try { Thread.sleep(msgEspera); } catch (InterruptedException e) { }
			if (pausa) {
				milis = System.currentTimeMillis();
			} else {
				c.actualizaFisica((System.currentTimeMillis()-milis) / 1000.0);
				milis = System.currentTimeMillis();
				if (c.y > limY) {
					c.y = limY;
					c.velY = -c.velY * 0.8;  // Rebota con 80% de restitución
					System.out.println( c.velY );
				}
				if (c.y >= limY-2 && pulsadoSalto) {  // Si está en el suelo o casi y se salta
					c.velY = -1000;
					pulsadoSalto = false;
				}
				if (c.x<0) { c.x = 0; c.velX = 100; }
				if (c.x>limX) { c.x = limX; c.velX = -100; }
				c.actualizaGrafico();
			}
		}
		// Si acaba cierra la ventana (se sale con escape... o con el icono de cierre)
		// Ojo - hay que quitar el dispose on close al poner el window listener,
		// porque si no al hacer click en el botón de cierre de la ventana,
		// los dos dispose() interfieren entre sí y este main se queda frito sin error
		dispose();
	}

	
	public static void main(String[] args) {
		Ejemplo2AnimacionCocheJLabel v = new Ejemplo2AnimacionCocheJLabel();
		v.setVisible( true );
		v.mueveElCoche5();
	}
	
	class MiKeyListener extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
				sigueJuego = false;
		}
	}

	class MiMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			pulsadoSalto = true;
		}
	}

	class MiActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			pausa = !pausa;
		}
	}

	class MiWindowListener extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent arg0) {
			System.out.println( "FINAL");
			sigueJuego = false;
		}
	}
}



class JLabelEscalableRotable extends JLabel {
	double rotacion;
	int ancho, alto;
	Image imagenObjeto;
	public JLabelEscalableRotable( ImageIcon objetoGrafico, int ancho, int alto, double rotacionInicial ) {
		super( objetoGrafico );
		this.ancho = ancho;
		this.alto = alto;
		rotacion = rotacionInicial;
		imagenObjeto = objetoGrafico.getImage();
	}
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;  // El Graphics realmente es Graphics2D
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);	
        g2.rotate( rotacion, ancho/2, alto/2 );
        g2.drawImage( imagenObjeto, 0, 0, ancho, alto, null);
        // Si se quieren dibujar los rectángulos interior y exterior:
		// setBorder( BorderFactory.createLineBorder( Color.red ));
        // g2.setColor( Color.white );
        // g2.setStroke(new BasicStroke(3));
        // g2.drawRect( xInicioChoque, yInicioChoque, xFinChoque-xInicioChoque, yFinChoque-yInicioChoque );
	}
}