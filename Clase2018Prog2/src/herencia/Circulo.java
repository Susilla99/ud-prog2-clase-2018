package herencia;

public class Circulo extends Figura{

	double radio;
	
	Circulo(double longitudRadio){
		this.radio=longitudRadio;
	}
	
	@Override
	void CalcularArea() {
		// TODO Auto-generated method stub
		area = radio*radio*3.14;
		System.out.println("el area es igual a "+ area);
	}
	
	

}
