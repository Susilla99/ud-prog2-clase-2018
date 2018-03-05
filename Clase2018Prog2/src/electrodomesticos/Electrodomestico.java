package electrodomesticos;

public class Electrodomestico {
	private float precioBase;
	private String color;
	private char consumoEnergetico;
	private float peso;
	
	
	Electrodomestico(){
		this.precioBase = 100;
		this.color = "Blanco";
		this.consumoEnergetico = 'F';
		this.peso = 5;
	}
	
	Electrodomestico(float precioBase, float peso){
		this.peso = peso;
		this.precioBase = precioBase;
		this.consumoEnergetico = 'F';
		this.color = "Blanco";
	}
	
	Electrodomestico(float precio, float peso, String color, char consumoEnergetico){
		this.precioBase = precio;
		this.peso = peso;
		this.color = comprobarColor(color);
		this.consumoEnergetico = comprobarConsumoEnergetico(consumoEnergetico);
		
	}
	
	private String comprobarColor(String color){
		if(color.equals("Blanco")||color.equals("Negro")||color.equals("Rojo")||color.equals("Azul")||color.equals("Gris")){
			return color;
		}else{
			return "Blanco";
		}
	}
	
	private char comprobarConsumoEnergetico(char consumo){
		
		switch(consumo){
		
		case 'A':
			return consumo;	
		case 'B':
			return consumo;
		case 'C':
			return consumo;
		case 'D':
			return consumo;
		case 'E':
			return consumo;
		default:
			return 'F';	
		}
	}
	
	public float precioFinal(){
		
		
		
		return 0;
	}
}
