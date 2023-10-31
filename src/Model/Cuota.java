package Model;

public class Cuota {
	private int nroCuota;
	private int montoTotalCuota;
	private boolean estaPaga;
	private String fecha_pago;
	private formaDePago formaPago;
	
	public Cuota(int nroCuota, int montoTotalCuota, boolean estaPaga, String fecha_pago, formaDePago formaPago) {
		super();
		this.nroCuota = nroCuota;
		this.montoTotalCuota = montoTotalCuota;
		this.estaPaga = estaPaga;
		this.fecha_pago = fecha_pago;
		this.formaPago = formaPago;
	}

	public Cuota() {
		super();
	}

	public int getNroCuota() {
		return nroCuota;
	}

	public void setNroCuota(int nroCuota) {
		this.nroCuota = nroCuota;
	}

	public int getMontoTotalCuota() {
		return montoTotalCuota;
	}

	public void setMontoTotalCuota(int montoTotalCuota) {
		this.montoTotalCuota = montoTotalCuota;
	}

	public boolean isEstaPaga() {
		return estaPaga;
	}

	public void setEstaPaga(boolean estaPaga) {
		this.estaPaga = estaPaga;
	}

	public String getFecha_pago() {
		return fecha_pago;
	}

	public void setFecha_pago(String fecha_pago) {
		this.fecha_pago = fecha_pago;
	}

	public formaDePago getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(formaDePago formaPago) {
		this.formaPago = formaPago;
	}
	
}
