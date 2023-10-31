package Model;

public abstract class Vehiculo {
	private String marca;
	private String modelo;
	private int año;
	private int nro_motor;
	private int nro_chasis;
	private String color;
	private int potenciaCV;
	private String matricula;
	
	public Vehiculo(String marca, String modelo, int año, int nro_motor, int nro_chasis, String color, int potenciaCV,
			String matricula) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.año = año;
		this.nro_motor = nro_motor;
		this.nro_chasis = nro_chasis;
		this.color = color;
		this.potenciaCV = potenciaCV;
		this.matricula = matricula;
	}

	public Vehiculo() {
		super();
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public int getNro_motor() {
		return nro_motor;
	}

	public void setNro_motor(int nro_motor) {
		this.nro_motor = nro_motor;
	}

	public int getNro_chasis() {
		return nro_chasis;
	}

	public void setNro_chasis(int nro_chasis) {
		this.nro_chasis = nro_chasis;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPotenciaCV() {
		return potenciaCV;
	}

	public void setPotenciaCV(int potenciaCV) {
		this.potenciaCV = potenciaCV;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	
}
