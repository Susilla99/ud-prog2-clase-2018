package superheroes.Villanos.DC;

import superheroes.Villanos.DC.Interfaces.IDCVillano;
import superheroes.Villanos.Villanos;

public class Joker extends Villanos implements IDCVillano {

	public Joker(int vida, String arma) {
		super(vida, arma);
	}

	@Override
	public void atacar() {
		System.out.println("ataque Joker");
		
	}

	@Override
	public void llamarEsbirros() {
		System.out.println("hola esbirro");
		
	}
	

}
