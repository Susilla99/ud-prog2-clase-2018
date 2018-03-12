package electrodomesticos;

public class ProgrPrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Electrodomestico[] arrayElectrodomestico = new Electrodomestico[10]; 
		arrayElectrodomestico[0]= new Lavadora(200,15);
		arrayElectrodomestico[1]= new Lavadora(250,40);
		arrayElectrodomestico[2]= new Lavadora(100,2);
		arrayElectrodomestico[3]= new Televison(100,4);
		arrayElectrodomestico[4]= new Televison(150.8f,5,"Gris",'A',50,true);
		arrayElectrodomestico[5]= new Lavadora();
		arrayElectrodomestico[6]= new Televison();
		arrayElectrodomestico[7]= new Lavadora(300,20);
		arrayElectrodomestico[8]= new Lavadora(10,50);
		arrayElectrodomestico[9]= new Lavadora(200,1000);
		
		
		float precioElectrodomesticos=0;
		float precioTelevisiones=0;
		float precioLavadoras = 0;
		for(int i=0; i<arrayElectrodomestico.length;i++){
			if(arrayElectrodomestico[i] instanceof Televison){
				precioTelevisiones+=((Televison)arrayElectrodomestico[i]).precioFinal();
			}
			if(arrayElectrodomestico[i] instanceof Lavadora){
				precioLavadoras+=((Lavadora)arrayElectrodomestico[i]).precioFinal();
			}
			precioElectrodomesticos+=((Electrodomestico)arrayElectrodomestico[i]).precioFinal();
		}
		
		System.out.println("Precio Teles: "+ precioTelevisiones);
		System.out.println("Precio Lavadoras: "+ precioLavadoras);
		System.out.println("Precio Electrodomesticos: "+ precioElectrodomesticos);
		
	}

}
