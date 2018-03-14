package superheroes.Villanos;

public abstract class Villanos {
	private int vida;
	private String arma;
	
	public Villanos(int vida, String arma){
		this.vida = vida;
		this.arma = arma;
	}
	
	public abstract void atacar();
	
	public void huir(){
		System.out.println("hola");
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public String getArma() {
		return arma;
	}

	public void setArma(String arma) {
		this.arma = arma;
	}
	
	
}
