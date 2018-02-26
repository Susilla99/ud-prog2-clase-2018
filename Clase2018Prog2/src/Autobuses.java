
public class Autobuses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int numRuedas;
	int numAsientos;
	int numPisos;
	String companyia;
	String nombreConductor;
	
	Autobuses(){
	}
	
	Autobuses(String nombreConductor){
		this.nombreConductor=nombreConductor;
	}
	Autobuses(int numeroRuedas){
		this.numRuedas=numeroRuedas;
	}
	
	public int getNumRuedas() {
		return numRuedas;
	}
	public void setNumRuedas(int numRuedas) {
		this.numRuedas = numRuedas;
	}
	public int getNumAsientos() {
		return numAsientos;
	}
	public void setNumAsientos(int numAsientos) {
		this.numAsientos = numAsientos;
	}
	public int getNumPisos() {
		return numPisos;
	}
	public void setNumPisos(int numPisos) {
		this.numPisos = numPisos;
	}
	public String getCompanyia() {
		return companyia;
	}
	public void setCompanyia(String companyia) {
		this.companyia = companyia;
	}
	public String getNombreConductor() {
		return nombreConductor;
	}
	public void setNombreConductor(String nombreConductor) {
		this.nombreConductor = nombreConductor;
	}
	
	void escribirDatos()
	{
		System.out.println("Nombre:"+nombreConductor+" Compa�ia:"+companyia+" NumeroAsientos:"+numAsientos);
	}
	
	Autobuses CrearClon(){
		Autobuses autobusClonado = new Autobuses();
		autobusClonado.companyia = companyia;
		autobusClonado.nombreConductor = nombreConductor;
		autobusClonado.numAsientos=numAsientos;
		autobusClonado.numPisos=numPisos;
		autobusClonado.numRuedas = numRuedas;
		return autobusClonado;
		
	}
}
