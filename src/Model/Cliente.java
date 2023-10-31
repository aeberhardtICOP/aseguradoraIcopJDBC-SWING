package Model;

public class Cliente {
	private String nombre;
	private String apellido;
	private String mail;
	private String genero;
	private int dni;
	private String domicilio;
	private int telefono;
	
	public Cliente(String nombre, String apellido, String mail, String genero, int dni, String domicilio, int telefono) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.genero=genero;
		this.dni = dni;
		this.domicilio = domicilio;
		this.telefono = telefono;
	}

	public Cliente() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	
}
