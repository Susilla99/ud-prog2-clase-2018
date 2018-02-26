package soldados;

import soldados.clones.Soldado;

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
			
			soldadoInicial = new Soldado("Soldado", arma);
			Batallon batallon = new Batallon(soldadoInicial, nombreBatallon);
			batallon.escribirPantalla();
		}
		
	}

}
