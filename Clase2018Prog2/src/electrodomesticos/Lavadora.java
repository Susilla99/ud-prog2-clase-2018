package electrodomesticos;

public class Lavadora extends Electrodomestico {

	private float carga;
	private static float CARGA_INICIAL=5;
	
	
	public Lavadora() {
		// TODO Auto-generated constructor stub
		this.carga=CARGA_INICIAL;
	}

	public Lavadora( float precioBase, float peso) {
		super(precioBase, peso);
		this.carga=CARGA_INICIAL;
		// TODO Auto-generated constructor stub
	}

	public Lavadora(float carga, float precio, float peso, String color, char consumoEnergetico) {
		super(precio, peso, color, consumoEnergetico);
		this.carga=carga;
		// TODO Auto-generated constructor stub
	}

	@Override
	public float precioFinal(){
		float precioSuperior=super.precioFinal();
		
		if(this.carga>30)
		{
			precioSuperior+=50;
		}
		
		return precioSuperior;
	}
}
