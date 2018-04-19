package tema05;

import java.util.Arrays;

public class EjemploEnums {

	public static void main(String[] args) {
		
		// Quiero usar colores de 4 tipos:
		// rojo, verde, azul, blanco

		// Me lo podría currar con strings... pero es muy fácil cometer errores
		String color = "rojo";
		color = "verde";
		color = "berde";
		
		// Podría codificarlo con enteros... pero ¿quién es quién? ¿Por qué 0 es rojo y no verde?		
		int color2 = 0;  // 0 rojo
		color2 = 1; // 1 verde
		
		// Solución: usar enums.  (ver abajo "MiColor")
		// Se pueden asignar directamente con información "simbólica" (identificadores)
		MiColor color3 = MiColor.ROJO;
		color3 = MiColor.VERDE;
		// Se pueden convertir desde strings (.valueOf)
		String colorEnString = "AZUL";
		color3 = MiColor.valueOf( colorEnString );
		// Se pueden convertir directamente a strings (toString por defecto de cualquier enum):
		System.out.println( color3 );
		// Se pueden recorrer muy fácil con un for each sobre .values():
		for (MiColor colorI : MiColor.values()) {
			System.out.println( colorI );
			System.out.println( colorI.ordinal() );   // .ordinal() saca el orden 0 a n-1 del enum en la lista
		}
		
	}

}

// Ejemplo ENUM:
enum MiColor {
	ROJO, VERDE, AZUL, BLANCO
	// Java internamente hace algo así:
	// public static Color ROJO = new MiColor( 0 );
	// public static Color VERDE = new MiColor( 1 );
	// public static Color AZUL = new MiColor( 2 );
	// public static Color BLANCO = new MiColor( 3 );
}
// Características de un enum:
// Solo valen los valores que indico (se crea un objeto por valor)
// Tienen ORDEN y se pueden comparar: ROJO < VERDE < AZUL < BLANCO


