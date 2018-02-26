package soldados.clones;

public abstract class Soldado {

	private String nombre;
	private String arma;
	
	public Soldado() {
		this.nombre="Soldado";
		this.arma="";
	}
	
	public Soldado(String nombre){
		this.nombre=nombre;
		this.arma="";
	}
	public Soldado(String nombre,String arma){
		this.arma=arma;
		this.nombre=nombre;
	}
	
	public abstract Soldado crearClon(String nombre);
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getArma() {
		return arma;
	}

	public void setArma(String arma) {
		this.arma = arma;
	}
}
