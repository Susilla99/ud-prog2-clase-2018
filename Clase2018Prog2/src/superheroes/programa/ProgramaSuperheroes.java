package superheroes.programa;

import superheroes.dc.Batman;
import superheroes.dc.interfaces.IDc;

public class ProgramaSuperheroes {

	public static void main(String[] args) {
		// Vamos a crear un array de 10 batmans con vidas incrementandolas en 10 es decir Batman1 = 100, 
		//Batman2 =110; batman3= 120.... Pero el array esta creado como de IDc
		
		IDc[] arrayBatmans = new IDc[10];
		int vida = 100;
		
		for (int i = 0; i < arrayBatmans.length; i++) {
			arrayBatmans[i]= new Batman(vida);
			vida+=10;
		}
		
		for(int i=0; i<10; i++) {
			System.out.println(""+((Batman)arrayBatmans[i]).getVida());
			arrayBatmans[i].llamarAlfred();
		}
		
	}

}
