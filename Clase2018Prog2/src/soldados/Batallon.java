package soldados;
import soldados.clones.*;
public class Batallon {

	Soldado s1;
	Soldado s2;
	Soldado s3;
	String nombreBatallon;
	
	public Batallon(Soldado soldado, String nombreBatallon){
		
		this.s1=soldado.crearClon("Soldado1");
//		this.s1.nombre="Soldado1";
		this.s2=soldado.crearClon("Soldado2");
//		this.s2.nombre="Soldado2";
		this.s3= soldado.crearClon("Soldado3");
//		this.s3.nombre="Soldado3";
		this.nombreBatallon=nombreBatallon;
		Artillero a = new Artillero();
	}
	
	public void escribirPantalla()
	{
		System.out.println("Batallon "+ nombreBatallon+ " con soldado "+s1.getNombre()+" y arma "+s1.getArma()+ " con soldado "+s2.getNombre()+" y arma "+s2.getArma()+" con soldado "+s3.getNombre()+" y arma "+s3.getArma());
	}
	
}
