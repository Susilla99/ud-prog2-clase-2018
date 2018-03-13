package superheroes.marvel;

import superheroes.Superheroe;
import superheroes.marvel.interfaces.IMarvel;

public class IronMan extends Superheroe implements IMarvel {

	public IronMan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IronMan(int vida){
		super(vida);
	}
	
	@Override
	public int darGolpe() {
		// TODO Auto-generated method stub
		return 100;
	}

	@Override
	public void llamarVengadores() {
		// TODO Auto-generated method stub
		System.out.println("Estoy llamando a Hulk");
	}

}
