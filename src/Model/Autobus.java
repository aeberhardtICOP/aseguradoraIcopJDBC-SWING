package Model;

public class Autobus extends Vehiculo {
	private int nroPlazas;

	public Autobus(String marca, String modelo, int año, int nro_motor, int nro_chasis, String color, int potenciaCV,
			String matricula, int nroPlazas) {
		super(marca, modelo, año, nro_motor, nro_chasis, color, potenciaCV, matricula);
		this.nroPlazas = nroPlazas;
	}

	public Autobus() {
		super();
	}

	public int getNroPlazas() {
		return nroPlazas;
	}

	public void setNroPlazas(int nroPlazas) {
		this.nroPlazas = nroPlazas;
	}
	
	

}
