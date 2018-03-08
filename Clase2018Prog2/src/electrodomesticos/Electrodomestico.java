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
		float precioFinal=0;
		switch(consumoEnergetico)
		{
		case 'A':
			precioFinal=precioBase+100;
			break;
		case 'B':
			precioFinal=precioBase+80;
			break;
		case 'C':
			precioFinal=precioBase+60;
			break;
		case 'D':
			precioFinal=precioBase+50;
			break;
		case 'E':
			precioFinal=precioBase+30;
			break;
		case 'F':
			precioFinal = precioBase+10;
		}
		
		if(peso>=0 && peso <=19){
			precioFinal+=10;
		}else
		{
			if(peso>19 && peso<=49)
			{
				precioFinal+=50;
			}else
			{
				if(peso>50 && peso<=79)
				{
					precioFinal+=80;
				}else
				{
					precioFinal+=100;
				}
			}
		}
		
		return precioFinal;
	}
	
	public void generarFactura(){
		System.out.println("Factura");
	}
}
