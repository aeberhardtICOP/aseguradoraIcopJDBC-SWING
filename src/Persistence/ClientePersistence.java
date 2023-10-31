package Persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import Model.Cliente;

public class ClientePersistence {
	Conection con = new Conection();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    
    public void crearCliente(Cliente cliente) {
    	try {
    		connection = con.conectar();
    		
            String sql = "INSERT INTO cliente (nombre, apellido, mail, genero, dni, domicilio, telefono, baja)"
            		+ "VALUES(?,?,?,?,?,?,?,?);";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cliente.getNombre());
            preparedStatement.setString(2, cliente.getApellido());
            preparedStatement.setString(3, cliente.getMail());
            preparedStatement.setString(4, cliente.getGenero());
            preparedStatement.setInt(5, cliente.getDni());
            preparedStatement.setString(6, cliente.getDomicilio());
            preparedStatement.setInt(7, cliente.getTelefono());
            preparedStatement.setBoolean(8, false);
            preparedStatement.executeUpdate();
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}finally {
    		cerrarRecursos(connection, preparedStatement, resultSet);
    	}
    }
    
    public HashMap<Integer, Cliente> traerClientes() {
    	try {
    		HashMap<Integer, Cliente>clientes=new HashMap();
    		connection = con.conectar();
            String sql = "SELECT * FROM cliente WHERE baja=false;";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            	 int id = resultSet.getInt("id_cliente");
                 String nombre = resultSet.getString("nombre");
                 String apellido = resultSet.getString("apellido");
                 String mail = resultSet.getString("mail");
                 String genero = resultSet.getString("genero");
                 String dni = resultSet.getString("dni");
                 String domicilio = resultSet.getString("domicilio");
                 String telefono = resultSet.getString("telefono");
                 String gen;
                 if(genero.equals("M")) {
                	 gen="Masculino";
                 }else if(genero.equals("F")) {
                	 gen="Femenino";
                 }else if(genero.equals("O")) {
                	 gen="Otro";
                 }else {
                	 gen="No especifica";
                 }
                 Cliente cli = new Cliente(nombre, apellido, mail, gen, Integer.parseInt(dni), domicilio, Integer.parseInt(telefono));
                 clientes.put(id, cli);
            }
            return clientes;
    	}catch(SQLException e) {
    		e.printStackTrace();
    		return null;
    	}finally {
    		cerrarRecursos(connection, preparedStatement, resultSet);
    	}
    }
    public void editar(Cliente cliente, int id) {
    	try {
    		connection = con.conectar();
    		
            String sql = "UPDATE cliente SET nombre = ?, apellido = ?, mail = ?,"
            		+ " genero = ?, dni = ?, domicilio = ?, telefono = ?, baja = ? "
            		+ "WHERE id_cliente = ?";
;
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cliente.getNombre());
            preparedStatement.setString(2, cliente.getApellido());
            preparedStatement.setString(3, cliente.getMail());
            preparedStatement.setString(4, cliente.getGenero());
            preparedStatement.setInt(5, cliente.getDni());
            preparedStatement.setString(6, cliente.getDomicilio());
            preparedStatement.setInt(7, cliente.getTelefono());
            preparedStatement.setBoolean(8, false);
            preparedStatement.setInt(9, id);
            preparedStatement.executeUpdate();
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}finally {
    		cerrarRecursos(connection, preparedStatement, resultSet);
    	}
    }
    public void baja(int id) {
    	try {
    		connection = con.conectar();
    		
            String sql = "UPDATE cliente SET baja = true WHERE id_cliente = ?";
;
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}finally {
    		cerrarRecursos(connection, preparedStatement, resultSet);
    	}
    }
    
    public int ultimoId() {
    	try {
    		connection = con.conectar();
    		
            String sql = "SELECT MAX(id_cliente) AS max_id FROM cliente;";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("max_id");
            } else { 
                return -1; 
            }
    	}catch(SQLException e) {
    		e.printStackTrace();
    		return -1;
    	}finally {
    		cerrarRecursos(connection, preparedStatement, resultSet);
    	}
    	
    }
    private void cerrarRecursos(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        try {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
