package tema05;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CositasVarias {

	public static void main(String[] args) {
		int[] vE = { 2, 7 };
		vE[1]++;
		ArrayList<Integer> misEnteros = new ArrayList<>();
		// misEnteros.add( new Integer(2) );
		misEnteros.add( 2 );  // boxing
		misEnteros.add( 7 );
		// int val = misEnteros.get(1).intValue();
		int val = misEnteros.get(1);   // Unboxing
		int val2 = misEnteros.get(1);
		val2++;
		misEnteros.set( 1, val2 );
		// Wrappers dan info añadida
		System.out.println( Integer.MAX_VALUE );
		System.out.println( Double.NEGATIVE_INFINITY );
		// int test = 2 / 0;  // Error de ejecución
		double test2 = 2.0 / 0.0;
		System.out.println( test2 );
		String ej = "2.5343";
		double d2 = Double.parseDouble( ej );
		System.out.println( d2 );
		int i2 = Integer.MAX_VALUE;
		i2++;
		System.out.println( i2 );
		System.out.println( Long.MAX_VALUE );
		
		System.out.println( System.currentTimeMillis());
		
		Date fecha = new Date( Long.MAX_VALUE );
		fecha = new Date();
		System.out.println( fecha );
		SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy HH:mm" );
		System.out.println( sdf.format( fecha ) );
		try {
			fecha = sdf.parse( "19/04/1918 13:55" );
		} catch (ParseException e) {
			System.out.println( "Fecha errónea");
		}
		System.out.println( fecha );
	}

}
