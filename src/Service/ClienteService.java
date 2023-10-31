package Service;

import java.security.KeyStore.Entry;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import Model.Cliente;
import Persistence.ClientePersistence;


public class ClienteService {
	ClientePersistence bd;
	Map<Integer, Cliente>clientes;
	
	
	
	public ClienteService() {
		this.bd = new ClientePersistence();
		clientes = new HashMap();
	}
	
	public void crearCliente(String nombre, String apellido, String mail, String genero, String dni, String domicilio, String telefono) {
		String gen = conversionGenero(genero);
		Cliente cli = new Cliente(nombre, apellido, mail, gen, Integer.parseInt(dni), domicilio, Integer.parseInt(telefono));
		int id = bd.ultimoId()+1;
		this.clientes.put(id, cli);
		bd.crearCliente(cli);
	}
	public void traerClientesMemoria() {
		this.clientes = bd.traerClientes();
		System.out.println(this.clientes.size());
	}
    public HashMap<Integer, Cliente> filtrarClientes(String nombre, String apellido, String mail, String dni, String domicilio, String telefono, String genero) {
    	System.out.println("Ingresando a hashmap...");
    	HashMap<Integer, Cliente> resultados = new HashMap<Integer, Cliente>();
         for (Map.Entry<Integer, Cliente> entry : this.clientes.entrySet()) {
        	 Integer idCliente = entry.getKey();
        	  Cliente cli = entry.getValue();
        	
        	 if ((nombre.isEmpty() || cli.getNombre().toLowerCase().contains(nombre.toLowerCase())) &&
                     (apellido.isEmpty()|| cli.getApellido().toLowerCase().contains(apellido.toLowerCase())) &&
                     (mail.isEmpty() || cli.getMail().toLowerCase().contains(mail.toLowerCase())) &&
                     (dni.isEmpty() || Integer.toString(cli.getDni()).equals(dni) &&
                     (domicilio.isEmpty() || cli.getDomicilio().trim().toLowerCase().contains(domicilio.trim().toLowerCase())) &&
                     (telefono.isEmpty() || Integer.toString(cli.getTelefono()).equals(telefono)) &&
                     (genero.isEmpty() || cli.getGenero().trim().toLowerCase().equals(genero.trim().toLowerCase())))) {
                     resultados.put(idCliente, cli);
                     System.out.println("genero="+genero+" cli.getGenero()="+cli.getGenero());
        	 }
         }
         return resultados;
    }
    public void editarCliente(String nombre, String apellido, String mail, String dni, String domicilio, String telefono, String genero, int id) {
    	String gen = conversionGenero(genero);
    	Cliente cli = new Cliente(nombre, apellido, mail, gen, Integer.parseInt(dni), domicilio, Integer.parseInt(telefono));
    	bd.editar(cli, id);
    	cli.setGenero(genero);
    	this.clientes.put(id, cli);
    }
    
    public void baja(int id) {
    	bd.baja(id);
    	clientes.remove(id);
    }
	public String conversionGenero(String genero) {
		String gen;
		if(genero=="Masculino") {
			gen="M";
		}else if(genero=="Femenino"){
			gen="F";
		}else if(genero=="Otro") {
			gen="O";
		}else {
			gen="N";
		}
		return gen;
	}
	public String conversionGeneroInversa(String genero) {
		String gen;
		if(genero=="M") {
			gen="Masculino";
		}else if(genero=="F"){
			gen="Femenino";
		}else if(genero=="O") {
			gen="Otro";
		}else {
			gen="No especifica";
		}
		return gen;
	}
}
