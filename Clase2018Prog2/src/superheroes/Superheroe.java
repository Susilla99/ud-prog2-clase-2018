package superheroes;

public abstract class Superheroe {

	private int vida;
	
	public Superheroe(){
		this.setVida(100);
	}
	
	public Superheroe(int vida)
	{
		this.setVida(vida);
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}
	
	public abstract int darGolpe();
}
