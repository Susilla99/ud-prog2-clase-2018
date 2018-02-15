
/**
 * @author andoni.eguiluz @ ingenieria.deusto.es
 *
 */
public class Base {

	static int i = 5;
	
	// Programa principal
	
	
	/** Método principal
	 * @param args	No utilizado
	 */
	public static void main(String[] pars) {
		int j = 762;
		double d;
		float f;  // Variable de prueba
		/*
		 * 
		 */
		j = 762; d = 1D; f = 1.5f; 
		System.out.println(f);
		
		m1();
		m2( 5, 'c' );
		System.out.println( suma( 2, 7 ) );
		System.out.println( suma( 2, suma(3,4)));
	}

	static boolean b;
	
	static void m1() {
		System.out.println( "soy m1" );
	}
	
	static void m2( int v1, char c2 ) {
		System.out.println( v1 + "\\\"" + c2 );
	}
	
	static int suma( int s1, int s2 ) {
		if (s2<0) {
			return s1-s2;
		} else {
			return s1+s2;
		}
	}
	
	static int suma( int s1, int s2, int s3 ) {
		return s1+s2+s3;
	}
	
	static int sumaTodos( double d, int...i ) {
		return 0;
	}

}
