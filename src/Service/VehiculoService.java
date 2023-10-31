package Service;
import Model.Vehiculo;
import Persistence.VehiculoPersistence;
import Model.Taxi;

import java.util.HashMap;
import java.util.Map;

import Model.Autobus;
public class VehiculoService {
	VehiculoPersistence bd;
	Map<Integer, Vehiculo>vehiculos;

	public VehiculoService() {
		this.bd=new VehiculoPersistence();
		this.vehiculos = new HashMap();
	}
	
	public void crearVehiculo(String tipo, String matricula, String modelo, String año, String potencia,
			String nroLicencia, String marca, String nroMotor, String nroChasis, String nroPlazas, String color) {
		if(tipo.equals("Taxi")) {
			String matri = matricula;
			String model = modelo;
			int cv = Integer.parseInt(potencia);
			String marc = marca;
			int ano = Integer.parseInt(año);
			int nroMot = Integer.parseInt(nroMotor);
			int nroChas = Integer.parseInt(nroChasis);
			String colo = color;
			int licencia = Integer.parseInt(nroLicencia);
			Taxi tax = new Taxi(marc, model, ano, nroMot, nroChas, colo, cv, matri, licencia);
			int id = bd.ultimoId();
			bd.crearVehiculo(tax, tipo);
			this.vehiculos.put(id, tax);
		}else if(tipo.equals("Autobus")) {
			String matri = matricula;
			String model = modelo;
			int cv = Integer.parseInt(potencia);
			String marc = marca;
			int ano = Integer.parseInt(año);
			int nroMot = Integer.parseInt(nroMotor);
			int nroChas = Integer.parseInt(nroChasis);
			String colo = color;
			int plazas = Integer.parseInt(nroPlazas);
			Autobus bus = new Autobus(marc, model, ano, nroMot, nroChas, colo, cv, matri, plazas);
			int id = bd.ultimoId();
			bd.crearVehiculo(bus, tipo);
			this.vehiculos.put(id, bus);
		}
	}
	
	public HashMap<Integer, Vehiculo> filtrarVehiculos(String matricula, String modelo, String marca, String tipo, String año, String color) {
	    System.out.println("Ingresando a hashmap...");
	    HashMap<Integer, Vehiculo> resultados = new HashMap<>();
	    String tip = null;
	    for (Map.Entry<Integer, Vehiculo> entry : this.vehiculos.entrySet()) {
	        Integer idVehiculo = entry.getKey();
	        Vehiculo vehiculo = entry.getValue();
	        if(vehiculo instanceof Taxi) {
	        	tip="Taxi";
	        }else if (vehiculo instanceof Autobus) {
	        	tip="Autobus";
	        }
	        System.out.println("MATRI: " + vehiculo.getMatricula());
	        System.out.println(matricula.isEmpty() || vehiculo.getMatricula().toLowerCase().contains(matricula.toLowerCase()));
	        System.out.println("MODELO: "+modelo + "-"+vehiculo.getModelo());
	        System.out.println(modelo.isEmpty() || vehiculo.getModelo().toLowerCase().contains(modelo.toLowerCase()));
	        System.out.println("MARCA "+marca+"-"+vehiculo.getMarca());
	        System.out.println(marca.isEmpty() || vehiculo.getMarca().toLowerCase().contains(marca.toLowerCase()));
	        System.out.println("TIPO:"+tipo+"-"+tip);
	        System.out.println(tipo.isEmpty() || tipo.equals(tip));
	        System.out.println("AÑO: "+año+"-"+vehiculo.getAño());
	        System.out.println(año.isEmpty() || Integer.toString(vehiculo.getAño()) == año);
	        System.out.println("COLOR: "+color+"-"+vehiculo.getColor());
	        System.out.println(color.isEmpty() || vehiculo.getColor().toLowerCase().contains(color.toLowerCase()));
	        
	        if ((matricula.isEmpty() || vehiculo.getMatricula().toLowerCase().contains(matricula.toLowerCase())) &&
	            (modelo.isEmpty() || vehiculo.getModelo().toLowerCase().contains(modelo.toLowerCase())) &&
	            (marca.isEmpty() || vehiculo.getMarca().toLowerCase().contains(marca.toLowerCase())) &&
	            (tipo.isEmpty() || tipo.equals(tip)) &&
	            (año.isEmpty() || Integer.toString(vehiculo.getAño()) == año) &&
	            (color.isEmpty() || vehiculo.getColor().toLowerCase().equals(color.toLowerCase()))) {
	            resultados.put(idVehiculo, vehiculo);
	            System.out.println("tipo=" + tipo + " tip" + tip);
	        }
	    }
	    return resultados;
	}
	public void traerVehiculos() {
		this.vehiculos=bd.traerVehiculos();
		System.out.println("Vehiculos en memoria: "+vehiculos.size()+ " vehiculos en memoria");
	}
	
	public Vehiculo buscarVehiculo(int id) {
		return this.vehiculos.get(id);
		
		
	}
	public void editarVehiculo(String id, String tipo, String matricula, String modelo, String año, String potencia,
			String nroLicencia, String marca, String nroMotor, String nroChasis, String nroPlazas, String color) {
		if(tipo.equals("Taxi")) {
			Taxi tax = new Taxi();
			tax.setMatricula(matricula);
			tax.setModelo(modelo);
			tax.setAño(Integer.parseInt(año));
			tax.setPotenciaCV(Integer.parseInt(potencia));
			tax.setMarca(marca);
			tax.setColor(color);
			tax.setNro_chasis(Integer.parseInt(nroChasis));
			tax.setNro_motor(Integer.parseInt(nroMotor));
			tax.setNroLicencia(Integer.parseInt(nroLicencia));
			this.vehiculos.put(Integer.parseInt(id), tax);
			bd.editarVehiculo(tax, tipo, Integer.parseInt(id));
		}else if (tipo.equals("Autobus")){
			Autobus bus = new Autobus();
			bus.setMatricula(matricula);
			bus.setModelo(modelo);
			bus.setAño(Integer.parseInt(año));
			bus.setPotenciaCV(Integer.parseInt(potencia));
			bus.setMarca(marca);
			bus.setColor(color);
			bus.setNro_chasis(Integer.parseInt(nroChasis));
			bus.setNro_motor(Integer.parseInt(nroMotor));
			bus.setNroPlazas(Integer.parseInt(nroPlazas));
			this.vehiculos.put(Integer.parseInt(id), bus);
			bd.editarVehiculo(bus, tipo, Integer.parseInt(id));
		}
	}
	
	
}
