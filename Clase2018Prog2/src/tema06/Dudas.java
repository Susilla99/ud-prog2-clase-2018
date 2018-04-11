package tema06;

import java.util.*;

public class Dudas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new A();
		B b = new B();
		a.mover( 10, 20 );
		b.mover( 20, 30 );
		ArrayList<Movible> movibles = new ArrayList<>();
		movibles.add( a );
		movibles.add( b );
		while (true) {
			// for (int i=0; i<movibles.size(); i++) {
			//    Movible m = movibles.get(i);
			for (Movible m : movibles)  {  // FOR-EACH
				m.mover( +1, +1 );
			}
		}
	}
	
	private static void ejemploMapas() {
		// Mapa 1 - nick --> Usuario
		HashMap<String,Usuario2> mapaUsuarios1 = new HashMap<>();
		Usuario2 u1 = new Usuario2();
		mapaUsuarios1.put( u1.getNick(), u1 );
		// Recuperar?
		mapaUsuarios1.get( "nick-ejemplo" );
		// Mapa 2 - nombre+ape --> Usuario
		HashMap<String,Usuario2> mapaUsuarios2 = new HashMap<>();
		mapaUsuarios2.put( u1.getNombre()+u1.getApes() , u1 );
		
		// Recorridos - por clave
		for (String clave : mapaUsuarios1.keySet()) {
			// System.out.println( clave );
			Usuario2 u = mapaUsuarios1.get( clave );
			// Hacer lo que quieras con el usuario
		}
		
		// Recorridos - por valor
		for (Usuario2 u : mapaUsuarios1.values()) {
			// Hacer lo que quieras con el usuario
		}
		
		// Recorridos - con iterador
		Iterator<String> it = mapaUsuarios1.keySet().iterator();
		while (it.hasNext()) {
			String clave = it.next();
			Usuario2 u = mapaUsuarios1.get( clave );
		}
		
		// Modificar
		Usuario2 andoni = mapaUsuarios1.get( "andoni" );
		if (andoni != null) {
			andoni.setPassword( "sdfsdfsdfsfd" );
			andoni.setNick( "andoni2" );  // EXCEPTO LA CLAVE
			//
			// Cambio de clave:
			mapaUsuarios1.remove( "andoni" );
			mapaUsuarios1.put( "andoni2", andoni );
		}
		
		
		
		
		
	}
}


class Usuario2 {
	String nick;   // Sirve como clave?
	String nombre;
	String apes;
	String password;
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApes() {
		return apes;
	}
	public void setApes(String apes) {
		this.apes = apes;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}


class A implements Movible {
	void m1 () { }
	@Override
	public void mover( double x, double y ) {}
}

class B implements Movible {
	void m2() { }
	@Override
	public void mover( double x, double y ) { }
}

class C implements Movible {

	@Override
	public void mover(double x, double y) {
		// TODO Auto-generated method stub
		
	}
	
}

interface Movible {
	/** Mueve el objeto incrementando sus coordenadas
	 * @param x	Incrementa la x en este valor
	 * @param y	Incrementa la y en este valor
	 */
	void mover( double x, double y );
	/** Devuelve la distancia a otro objeto movible
	 * @param x	X de ese otro objeto
	 * @param y	Y de ese otro objeto
	 * @return	Distancia en 2D del objeto en curso a ese otro
	 */
	// double distanciaA( double x, double y );
}









