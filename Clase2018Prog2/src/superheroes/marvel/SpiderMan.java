package superheroes.marvel;

import superheroes.Superheroe;
import superheroes.marvel.interfaces.IMarvel;

public class SpiderMan extends Superheroe implements IMarvel{

	public SpiderMan() {
		// TODO Auto-generated constructor stub
	}

	public SpiderMan(int vida) {
		super(vida);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int darGolpe() {
		// TODO Auto-generated method stub
		return 25;
	}

	@Override
	public void llamarVengadores() {
		// TODO Auto-generated method stub
		System.out.println("Estoy llamando a tia May");
	}

}
