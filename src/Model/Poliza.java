package Model;

import java.util.ArrayList;

public class Poliza {
	private static int nro=1000;
	private Vehiculo vehiculo;
	private Cliente cliente;
	private int nroPoliza;
	private String fecha_inicio;
	private String fecha_fin;
	private int cantidadCuotas;
	private formaDePago formaPago;
	private int montoTotalAsegurado;
	private boolean incluyeGranizo;
	private int montoGranizoMaximo;
	private tipoCobertura tipoCobertura;
	private int montoCuota;
	private ArrayList<Cuota>cuotas;
	public Poliza(Vehiculo vehiculo, Cliente cliente, int nroPoliza, String fecha_inicio, String fecha_fin,
			int cantidadCuotas, formaDePago formaPago, int montoTotalAsegurado, boolean incluyeGranizo,
			int montoGranizoMaximo, Model.tipoCobertura tipoCobertura, int montoCuota, ArrayList<Cuota> cuotas) {
		super();
		this.vehiculo = vehiculo;
		this.cliente = cliente;
		this.nroPoliza = nroPoliza;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.cantidadCuotas = cantidadCuotas;
		this.formaPago = formaPago;
		this.montoTotalAsegurado = montoTotalAsegurado;
		this.incluyeGranizo = incluyeGranizo;
		this.montoGranizoMaximo = montoGranizoMaximo;
		this.tipoCobertura = tipoCobertura;
		this.montoCuota = montoCuota;
		this.cuotas = cuotas;
	}
	public Poliza() {
		super();
	}
	public static int getNro() {
		return nro;
	}
	public static void setNro(int nro) {
		Poliza.nro = nro;
	}
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public int getNroPoliza() {
		return nroPoliza;
	}
	public void setNroPoliza(int nroPoliza) {
		this.nroPoliza = nroPoliza;
	}
	public String getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public String getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	public int getCantidadCuotas() {
		return cantidadCuotas;
	}
	public void setCantidadCuotas(int cantidadCuotas) {
		this.cantidadCuotas = cantidadCuotas;
	}
	public formaDePago getFormaPago() {
		return formaPago;
	}
	public void setFormaPago(formaDePago formaPago) {
		this.formaPago = formaPago;
	}
	public int getMontoTotalAsegurado() {
		return montoTotalAsegurado;
	}
	public void setMontoTotalAsegurado(int montoTotalAsegurado) {
		this.montoTotalAsegurado = montoTotalAsegurado;
	}
	public boolean isIncluyeGranizo() {
		return incluyeGranizo;
	}
	public void setIncluyeGranizo(boolean incluyeGranizo) {
		this.incluyeGranizo = incluyeGranizo;
	}
	public int getMontoGranizoMaximo() {
		return montoGranizoMaximo;
	}
	public void setMontoGranizoMaximo(int montoGranizoMaximo) {
		this.montoGranizoMaximo = montoGranizoMaximo;
	}
	public tipoCobertura getTipoCobertura() {
		return tipoCobertura;
	}
	public void setTipoCobertura(tipoCobertura tipoCobertura) {
		this.tipoCobertura = tipoCobertura;
	}
	public int getMontoCuota() {
		return montoCuota;
	}
	public void setMontoCuota(int montoCuota) {
		this.montoCuota = montoCuota;
	}
	public ArrayList<Cuota> getCuotas() {
		return cuotas;
	}
	public void setCuotas(ArrayList<Cuota> cuotas) {
		this.cuotas = cuotas;
	}
	
	
}
