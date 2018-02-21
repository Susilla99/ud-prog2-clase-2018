
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
	}

}
