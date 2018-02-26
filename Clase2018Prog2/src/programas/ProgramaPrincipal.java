package programas;

import soldados.Batallon;
import soldados.clones.Artillero;
import soldados.clones.Soldado;
import soldados.clones.francotiradores.Francotirador;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Soldado soldadoInicial;
		String nombreBatallon="Batallon";
		
		for(int i=1;i<5;i++)
		{
			nombreBatallon="Batallon"+i;
			String arma ="";
			switch(i){
			case 1:
				arma="cuchillo";
				break;
			case 2:
				arma="puño";
				break;
			case 3:
				arma="pistola";
				break;
			case 4: 
				arma="blaster";
				break;
			}
			
			soldadoInicial = new Francotirador("Soldado", arma, 10.0);
			Batallon batallon = new Batallon(soldadoInicial, nombreBatallon);
			batallon.escribirPantalla();
		}
		
	}

}
