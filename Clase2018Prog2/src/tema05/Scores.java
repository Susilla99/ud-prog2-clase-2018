package tema05;

import java.util.*;

/** Gesti�n de usuarios con scores
 * Los usuarios se identifican con nicks �nicos
 * y da igual min�sculas que may�sculas
 * (independiente del caso, o de la capitalizaci�n)
 * @author andoni.eguiluz @ ingenieria.deusto.es
 */
public class Scores {
	private TreeMap<String,ArrayList<Integer>> mapaPunts;
	
	/** Construye un nuevo espacio de scores vac�o
	 */
	public Scores() {
		mapaPunts = new TreeMap<>();
	}
	
	/** A�ade al espacio de scores un usuario nuevo
	 * sin puntuaci�n. Si el usuario ya exist�a
	 * lo deja como estaba
	 * @param nick	Nick del usuario a a�adir
	 */
	public void addUsuario( String nick ) {
		nick = nick.toLowerCase();
		if (!mapaPunts.containsKey( nick )) {
			mapaPunts.put( nick, new ArrayList<Integer>() );
		}
	}

	/** A�ade al espacio de scores un usuario nuevo
	 * o existente, con su nueva puntuaci�n.
	 * @param nick	Nick del usuario a a�adir/modificar
	 * @param puntuacion	Nueva puntuaci�n de ese usuario
	 */
	public void addPuntuacion( String nick, int puntuacion ) {
		nick = nick.toLowerCase();
		if (!mapaPunts.containsKey( nick )) {
			ArrayList<Integer> l = new ArrayList<>();
			l.add( puntuacion );
			mapaPunts.put( nick, l );
		} else {
			mapaPunts.get( nick ).add( puntuacion );
			// Otra manera
			// ArrayList<Integer> l = mapaPunts.get(nick);
			// l.add( puntuacion );
		}
	}
		
	public boolean existe( String nick ) {
		nick = nick.toLowerCase();
		return mapaPunts.containsKey( nick );
	}
	
	/** Devuelve el high score del usuario indicado
	 * @param nick	Usuario a consultar
	 * @return	Su highscore, -1 si no existe el usuario o 
	 * si no existe ninguna puntuaci�n
	 */
	public int getHighScore( String nick ) {
		nick = nick.toLowerCase();
		ArrayList<Integer> l = mapaPunts.get( nick );
		if (l==null || l.size()==0) {
			return -1;
		} else {
			return Collections.max( l );
		}
	}
	
	/** Devuelve todas las puntuaciones del usuario indicado
	 * @param nick	Usuario a consultar
	 * @return	Sus scores, null si no existe el usuario
	 */
	public ArrayList<Integer> getScores( String nick ) {
		nick = nick.toLowerCase();
		// o bien return mapaPunts.get(nick);
		ArrayList<Integer> l = mapaPunts.get( nick );
		if (l==null) {
			return null;
		} else {
			return l;
		}
	}
	
	public ArrayList<String> getUsuariosFieles() {
		ArrayList<String> ret = new ArrayList<>();
		for (String nick : mapaPunts.keySet()) {
			ret.add( nick );
		}
		// Collections.sort( ret );  // Ordenaci�n natural
		Comparator<String> c = new ComparadorFidelidad( this );
		ret.sort(c);
		return ret;
	}
	
	@Override
	public String toString() {
		return mapaPunts.toString();
	}
	
	public static void main(String[] args) {
		Scores punts = new Scores();
		punts.addUsuario( "ainhoa" );
		punts.addUsuario( "andoni" );
		if (punts.existe("Andoni")) 
			System.out.println( "Ya estaba" );
		punts.addUsuario( "Andoni" );
		punts.addPuntuacion( "Ainhoa", 150 );
		punts.addPuntuacion( "ainhoa", 50 );
		punts.addPuntuacion( "ainhoa", 200 );
		System.out.println( "Punt max Ainhoa = " +
				punts.getHighScore( "ainhoa" ));
		System.out.println( "Punt max Andoni = " +
				punts.getHighScore( "Andoni" ));
		punts.addPuntuacion( "luis", 100 );
		punts.addPuntuacion( "luis", 90 );
		punts.addPuntuacion( "amaia", 25 );
		System.out.println( punts );
		System.out.println( punts.getUsuariosFieles() );
	}

}
