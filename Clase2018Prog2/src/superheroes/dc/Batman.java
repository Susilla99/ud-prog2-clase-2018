package superheroes.dc;

import superheroes.Superheroe;
import superheroes.dc.interfaces.IDc;

public class Batman extends Superheroe implements IDc{

	public Batman() {
		// TODO Auto-generated constructor stub
	}

	public Batman(int vida) {
		super(vida);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int darGolpe() {
		// TODO Auto-generated method stub
		return 50;
	}

	@Override
	public void llamarAlfred() {
		// TODO Auto-generated method stub
		System.out.println("Estoy llamando a Alfred");
	}

}
