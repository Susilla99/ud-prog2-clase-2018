
public class ProgramaPrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Autobuses autobus1 = new Autobuses();
		autobus1.setCompanyia("ALSA");
		autobus1.setNombreConductor("Juan");
		autobus1.setNumAsientos(50);
		autobus1.setNumPisos(1);
		autobus1.setNumRuedas(6);
		
		Autobuses autobus2 = new Autobuses();
		
		autobus2.companyia = autobus1.companyia;
		autobus2.nombreConductor = autobus1.nombreConductor;
		autobus2.numAsientos = autobus1.numAsientos;
		autobus2.numPisos = autobus1.numPisos;
		autobus2.numRuedas = autobus1.numRuedas;
		
		
		autobus1.escribirDatos();
		autobus2.escribirDatos();
		
		autobus1.setCompanyia("PESA");
		
		autobus1.escribirDatos();
		autobus2.escribirDatos();
		ProgramaPrincipal programa = new ProgramaPrincipal();
		int numeroAProbar = 1;
		System.out.println("Nombre autobus1: "+ autobus1.nombreConductor);
		System.out.println("numero a probar= "+numeroAProbar);
		programa.cambiarNombreConductor(autobus1,numeroAProbar);
		System.out.println("Nombre despues del metodo ="+ autobus1.nombreConductor);
		System.out.println("numero a probar despues del metodo= "+numeroAProbar);
		
		Autobuses autobuses4 = new Autobuses("Juanito");
		System.out.println("autobus4: "+autobuses4.nombreConductor);
		
	}

	void cambiarNombreConductor(Autobuses autobus, int numero){
		//autobus.setNombreConductor("PEPE");
		numero=15;
		Autobuses autobusClon = autobus.CrearClon();
		System.out.println("Nombre del autobusClon = "+autobusClon.nombreConductor);
		autobusClon.nombreConductor="Javi";
		System.out.println("Nombre conductor= "+autobus.nombreConductor);

		System.out.println("Nombre conductorClon= "+autobusClon.nombreConductor);
		System.out.println("el numero="+numero);
	}
}
