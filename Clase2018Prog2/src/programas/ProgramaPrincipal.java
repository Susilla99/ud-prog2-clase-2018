package programas;

import soldados.Batallon;
import soldados.clones.Artillero;
import soldados.clones.Soldado;
import soldados.clones.francotiradores.Francotirador;
import soldados.clones.francotiradores.ITiradores;
import soldados.clones.francotiradores.TiradorPistola;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Soldado soldadoInicial;
//		String nombreBatallon="Batallon";
//	
//		for(int i=1;i<5;i++)
//		{
//			nombreBatallon="Batallon"+i;
//			String arma ="";
//			switch(i){
//			case 1:
//				arma="cuchillo";
//				break;
//			case 2:
//				arma="puño";
//				break;
//			case 3:
//				arma="pistola";
//				break;
//			case 4: 
//				arma="blaster";
//				break;
//			}
//			
//			soldadoInicial = new Francotirador("Soldado", arma, 10.0);
//			Batallon batallon = new Batallon(soldadoInicial, nombreBatallon);
//			batallon.escribirPantalla();
//		}
//		
		
//		ITiradores tirador = new Francotirador("Pepe", "Cuchillo", 100);
//		ITiradores[] tiradores = new ITiradores[2];
//		tiradores[0]= tirador;
//		tiradores[1]= new TiradorPistola();
//		for(int i = 0; i<tiradores.length;i++){
//			System.out.println(""+tiradores[i].getNumDisparos());
//		}
		
		
		Batallon b = new Batallon( "Batallon1", 500);
		b.escribirPantalla();
	}

}
