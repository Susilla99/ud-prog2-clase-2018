package electrodomesticos;

public class Televison extends Electrodomestico {
	 private float resolucion;
	 private boolean sintonizadorTDT;
	

	public Televison() {
		super();
		this.resolucion = 20;
		this.sintonizadorTDT = false;
	}

	public Televison(float precio, float peso, String color, char consumoEnergetico, float resolucion, boolean sintonizadorTDT) {
		super(precio, peso, color, consumoEnergetico);
		this.sintonizadorTDT = sintonizadorTDT;
		this.resolucion = resolucion;
		
		
		// TODO Auto-generated constructor stub
	}

	public Televison(float precioBase, float peso) {
		super(precioBase, peso);
		this.resolucion = 20;
		this.sintonizadorTDT = false;
		// TODO Auto-generated constructor stub
	}

	public float getResolucion() {
		return resolucion;
	}

	public boolean isSintonizadorTDT() {
		return sintonizadorTDT;
	}

	@Override
	public float precioFinal() {
		// TODO Auto-generated method stub
	
		float precio_nuevo = super.precioFinal();
		if(this.resolucion > 40) {
			precio_nuevo = (float) (precio_nuevo + precio_nuevo * 0.30);
		}
		if(this.sintonizadorTDT) {
			precio_nuevo = precio_nuevo + 50;
		}
		return precio_nuevo;
		
	}
	
	
	
	

}
