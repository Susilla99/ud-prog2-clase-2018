package herencia;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Figura figura1;
//		
//		for(int i=1;i<=2;i++){
//			if(i==1){
//				figura1=new Circulo(6);
//			}else
//			{
//				figura1=new Cuadrado(2);
//			}
//			
//			figura1.CalcularArea();
//		}
		
		
		figura1 = new Circulo(7);
		figura1.CalcularArea();
		Double radioTemporal = ((Circulo)figura1).radio;
		
		System.out.println("El valor del radio temporal es: "+radioTemporal);
		figura1.CalcularArea();
		System.out.println("Cambio de figura");
		figura1= new Cuadrado(3);
		figura1.CalcularArea();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		if(figura1 instanceof Circulo){
			((Circulo)figura1).radio=9;
				
		}
		if (figura1 instanceof Cuadrado){
			((Cuadrado)figura1).lado=5;
		}
		figura1.CalcularArea();
		
	}

}
