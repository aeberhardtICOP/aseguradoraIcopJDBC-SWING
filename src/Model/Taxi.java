package Model;

public class Taxi extends Vehiculo {
	private int nroLicencia;

	public Taxi(String marca, String modelo, int año, int nro_motor, int nro_chasis, String color, int potenciaCV,
			String matricula, int nroLicencia) {
		super(marca, modelo, año, nro_motor, nro_chasis, color, potenciaCV, matricula);
		this.nroLicencia = nroLicencia;
	}

	public Taxi() {
		super();
	}

	public int getNroLicencia() {
		return nroLicencia;
	}

	public void setNroLicencia(int nroLicencia) {
		this.nroLicencia = nroLicencia;
	}
	
	
}
