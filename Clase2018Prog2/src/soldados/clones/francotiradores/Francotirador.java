package soldados.clones.francotiradores;

import soldados.clones.Soldado;

public class Francotirador extends Soldado {
	
	private double long_mira;

	public Francotirador(String nombre, String arma, double longitud){
		super(nombre,arma);
		this.long_mira=longitud;
		
		
	}
	
	public double getLong_mira() {
		return long_mira;
	}

	public void setLong_mira(double long_mira) {
		this.long_mira = long_mira;
	}

}
