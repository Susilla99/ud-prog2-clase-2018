
public class Calculadora{

	public static void main(String[] a){
//		Calculadora calc1 = new Calculadora();
//		calc1.teclearNumero( 7 );
//		calc1.verEnPantalla();
//		calc1.pulsarCuadrado();
//		calc1.verEnPantalla();
//		Calculadora calc2 = new Calculadora();
//		
//		calc2.verEnPantalla();
//		
//		
//		
//		
//		String variable1 ="soy1";
//		String variable2 ="soy2";
//		
//		
//		if(calc1.comprobarTextos(variable1, variable2)) {
//			System.out.println("iguales");
//		}else {
//			System.out.println("no iguales");
//		}
//		
		
		Calculadora calculadoraInicial = new Calculadora();
		
		calculadoraInicial.teclearNumero(9);
		
		Calculadora calculadoraCopia = new Calculadora();
		calculadoraCopia.numEnPantalla=calculadoraInicial.numEnPantalla;
		
		calculadoraInicial.verEnPantalla();
		calculadoraCopia.verEnPantalla();
		
		
		calculadoraInicial.teclearNumero(6);
		calculadoraInicial.verEnPantalla();
		calculadoraCopia.verEnPantalla();
		
		
		Calculadora calculadoraTercera = calculadoraInicial;
		Calculadora calculadoraCuarta = new Calculadora();
		calculadoraCuarta.numEnPantalla=calculadoraTercera.numEnPantalla;
	}
	
	double numEnPantalla;
	
	/** Toma el número que está en pantalla
	 * lo eleva al cuadrado y deja el resultado
	 * en pantalla
	 */
	void pulsarCuadrado() {
		numEnPantalla = numEnPantalla * numEnPantalla;
		// o numEnPantalla *= numEnPantalla
	}
	
	/** Visualiza en consola la pantalla
	 */
	void verEnPantalla() {
		System.out.println( numEnPantalla );
	}
	
	/** Teclea el número indicado y lo muestra en pantalla
	 * @param numero	Número tecleado
	 */
	void teclearNumero( int numero ) {
		String v="Hola";
		if(v.equals("Hola mundo"))
		{
			
		}else
		{
			
		}
		numEnPantalla = (double) numero;
	}
	boolean comprobarTextos(String var1, String var2) {
		if(var1.equals(var2)) {
			return true;
		}else {
			return false;
		}
	}
}
