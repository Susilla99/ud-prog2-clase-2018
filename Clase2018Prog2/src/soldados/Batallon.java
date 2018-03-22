package soldados;

import java.util.ArrayList;

import soldados.clones.Artillero;
import soldados.clones.Soldado;
import soldados.clones.francotiradores.Francotirador;

public class Batallon {

	ArrayList<Soldado> soldadosBatallon= new ArrayList<Soldado>();
	String nombreBatallon;
	
	public Batallon(String nombreBatallon, int numeroSoldados){
		
		for(int i = 0;i<numeroSoldados;i++){
			Soldado s = new Francotirador("soldado"+i, "rifle", 200.0+i);
			soldadosBatallon.add(s);
		}
		
		this.nombreBatallon=nombreBatallon;
		
	}
	
	public void escribirPantalla()
	{
		for(int i =0; i<soldadosBatallon.size();i++){
			System.out.println(soldadosBatallon.get(i).getNombre());
		}
	}
	
}
