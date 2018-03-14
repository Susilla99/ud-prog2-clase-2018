package superheroes.Villanos.Marvel;

import superheroes.Villanos.Villanos;

public class Ultron extends Villanos{

	public Ultron(int vida, String arma) {
		super(vida, arma);
	}

	@Override
	public void atacar() {
		System.out.println("Ataque Ultron");
		
	}

}
