
public class GestionMemoria {
	private static String temp = "sus bytes";
	public static void main(String[] args) {
		System.out.println( Runtime.getRuntime().freeMemory() );
		String s[] = null;
		System.out.println( Runtime.getRuntime().freeMemory() );
		s = new String[10000];
		System.out.println( Runtime.getRuntime().freeMemory() );
		for (String st : s)
			System.out.print( st + "\t" );
		System.out.println();
		System.out.println( Runtime.getRuntime().freeMemory() );
		s = null;  // Se quita la referencia
		System.out.println( Runtime.getRuntime().freeMemory() );
		System.gc();  // Garbage collector
		System.out.println( Runtime.getRuntime().freeMemory() );
	}

}
