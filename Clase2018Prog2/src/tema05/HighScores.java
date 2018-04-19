package tema05;

import java.util.*;

/** Gesti�n de usuarios con scores
 * Los usuarios se identifican con nicks �nicos
 * y da igual min�sculas que may�sculas
 * (independiente del caso, o de la capitalizaci�n)
 * @author andoni.eguiluz @ ingenieria.deusto.es
 */
public class HighScores {
	private TreeMap<String,Integer> mapaPunts;
	
	/** Construye un nuevo espacio de high scores
	 * vac�o
	 */
	public HighScores() {
		mapaPunts = new TreeMap<String,Integer>();
	}
	
	/** A�ade al espacio de high scores un usuario nuevo
	 * sin puntuaci�n. Si el usuario ya exist�a
	 * lo dejo como estaba
	 * @param nick	Nick del usuario a a�adir
	 */
	public void addUsuario( String nick ) {
		nick = nick.toLowerCase();
		if (!mapaPunts.containsKey( nick )) {
		// if (mapaPunts.get(nick)==null) {
			mapaPunts.put( nick, null );  // Puntuaci�n null = sin puntuaci�n
		}
	}

	/** A�ade al espacio de high scores un usuario nuevo
	 * o existente, con su puntuaci�n. Si ya ten�a
	 * una puntuaci�n mayor que esta, la deja
	 * @param nick	Nick del usuario a a�adir/modificar
	 * @param puntuacion	Puntuaci�n de ese usuario
	 */
	public void addPuntuacion( String nick, int puntuacion ) {
		nick = nick.toLowerCase();
		if (!mapaPunts.containsKey( nick )) {
			mapaPunts.put( nick, new Integer(puntuacion) );
		} else {
			Integer puntAnt = mapaPunts.get( nick );
			if (puntAnt==null || puntAnt < puntuacion) {
				mapaPunts.remove( nick );  // Opcional
				mapaPunts.put( nick, puntuacion );
			}
		}
	}
		
	public boolean existe( String nick ) {
		nick = nick.toLowerCase();
		return mapaPunts.containsKey( nick );
	}
	
	/** Devuelve el high score del usuario indicado
	 * @param nick	Usuario a consultar
	 * @return	Su highscore, -1 si no existe
	 */
	public int getHighScore( String nick ) {
		nick = nick.toLowerCase();
		if (mapaPunts.containsKey( nick )) {
			Integer i = mapaPunts.get( nick );
			if (i==null)
				return -1;
			else
				return i;
		} else {
			return -1;
		}
	}
	
	public ArrayList<Integer> getMejoresPunts() {
		ArrayList<Integer> ret = new ArrayList<>();
		for (Integer i : mapaPunts.values()) {
			if (i!=null) {
				ret.add( i );
			}
		}
		// Collections.sort( ret );  // Ordenaci�n natural
		Comparator<Integer> c = new ComparaAlReves();
		ret.sort(c);
		return ret;
	}
	
	@Override
	public String toString() {
		return mapaPunts.toString();
	}
	
	public static void main(String[] args) {
		HighScores punts = new HighScores();
		punts.addUsuario( "ainhoa" );
		punts.addUsuario( "andoni" );
		if (punts.existe("Andoni")) 
			System.out.println( "Ya estaba" );
		punts.addUsuario( "Andoni" );
		punts.addPuntuacion( "Ainhoa", 150 );
		punts.addPuntuacion( "ainhoa", 50 );
		punts.addPuntuacion( "ainhoa", 200 );
		System.out.println( "Punt Ainhoa = " +
				punts.getHighScore( "ainhoa" ));
		System.out.println( "Punt Andoni = " +
				punts.getHighScore( "Andoni" ));
		System.out.println( punts );
		punts.addPuntuacion( "luis", 100 );
		punts.addPuntuacion( "amaia", 25 );
		System.out.println( punts.getMejoresPunts() );
	}

}
