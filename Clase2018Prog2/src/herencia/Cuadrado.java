package herencia;

public class Cuadrado extends Figura {

	double lado;
	
	Cuadrado(double longitudLado){
		this.lado=longitudLado;
	}
	
	@Override
	void CalcularArea() {
		// TODO Auto-generated method stub
		area = lado*lado;
		System.out.println("El area del cuadrado es "+area);
	}

}
