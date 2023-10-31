package Persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;

import Model.Taxi;
import Model.Autobus;
import Model.Vehiculo;

public class VehiculoPersistence {
	Conection con = new Conection();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    
    public void crearVehiculo(Vehiculo vehiculo, String tipo) {
        try {
            connection = con.conectar();

            String sql = "INSERT INTO vehiculo (matricula, modelo, potencia_cv, tipo, marca, año, nro_motor, nro_chasis, color, baja, nro_licencia, nro_plazas)"
            		+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?);";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, vehiculo.getMatricula());
            preparedStatement.setString(2, vehiculo.getModelo());
            preparedStatement.setInt(3, vehiculo.getPotenciaCV());
            preparedStatement.setString(4, tipo);
            preparedStatement.setString(5, vehiculo.getMarca());
            preparedStatement.setInt(6, vehiculo.getAño());
            preparedStatement.setInt(7, vehiculo.getNro_motor());
            preparedStatement.setInt(8, vehiculo.getNro_chasis());
            preparedStatement.setString(9, vehiculo.getColor());
            preparedStatement.setBoolean(10, false); 
            if (vehiculo instanceof Taxi) {
                preparedStatement.setInt(11, ((Taxi) vehiculo).getNroLicencia());
                preparedStatement.setNull(12, Types.INTEGER); 
            } else if (vehiculo instanceof Autobus) {
                preparedStatement.setNull(11, Types.INTEGER);
                preparedStatement.setInt(12, ((Autobus) vehiculo).getNroPlazas());
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarRecursos(connection, preparedStatement, resultSet);
        }
    }

    public HashMap<Integer, Vehiculo> traerVehiculos() {
    	HashMap<Integer, Vehiculo> vehiculos = new HashMap<>();
        try {
            connection = con.conectar();
            String sql = "SELECT * FROM vehiculo WHERE baja=false;";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_vehiculo");
                String matricula = resultSet.getString("matricula");
                String modelo = resultSet.getString("modelo");
                int potenciaCV = resultSet.getInt("potencia_cv");
                String tipo = resultSet.getString("tipo");
                String marca = resultSet.getString("marca");
                int ano = resultSet.getInt("año");
                int nroMotor = resultSet.getInt("nro_motor");
                int nroChasis = resultSet.getInt("nro_chasis");
                String color = resultSet.getString("color");
                boolean baja = resultSet.getBoolean("baja");
                if (resultSet.getString("nro_licencia") != null) {
                    int nroLicencia = resultSet.getInt("nro_licencia");
                    Taxi taxi = new Taxi(marca, modelo, ano, nroMotor, nroChasis, color,  potenciaCV, matricula, nroLicencia);
                    vehiculos.put(id, taxi);
                } else {
                    int nroPlazas = resultSet.getInt("nro_plazas");
                    Autobus autobus = new Autobus(marca, modelo, ano, nroMotor, nroChasis, color,  potenciaCV, matricula, nroPlazas);
                    vehiculos.put(id, autobus);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarRecursos(connection, preparedStatement, resultSet);
        }
        return vehiculos;
    }

    public void editarVehiculo(Vehiculo vehiculo, String tipo, int id) {
        try {
            connection = con.conectar();
            String sql = "UPDATE vehiculo SET matricula = ?, modelo = ?, potencia_cv = ?, tipo = ?, marca = ?, año = ?, nro_motor = ?, nro_chasis = ?, color = ?, baja = ?, nro_licencia = ?, nro_plazas = ? WHERE id_vehiculo = ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, vehiculo.getMatricula());
            preparedStatement.setString(2, vehiculo.getModelo());
            preparedStatement.setInt(3, vehiculo.getPotenciaCV());
            preparedStatement.setString(4, tipo);
            preparedStatement.setString(5, vehiculo.getMarca());
            preparedStatement.setInt(6, vehiculo.getAño());
            preparedStatement.setInt(7, vehiculo.getNro_motor());
            preparedStatement.setInt(8, vehiculo.getNro_chasis());
            preparedStatement.setString(9, vehiculo.getColor());
            preparedStatement.setBoolean(10, false);
            if (vehiculo instanceof Taxi) {
                preparedStatement.setInt(11, ((Taxi) vehiculo).getNroLicencia());
                preparedStatement.setNull(12, Types.INTEGER);
            } else if (vehiculo instanceof Autobus) {
                preparedStatement.setNull(11, Types.VARCHAR);
                preparedStatement.setInt(12, ((Autobus) vehiculo).getNroPlazas());
            }
            preparedStatement.setInt(13,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarRecursos(connection, preparedStatement, resultSet);
        }
    }

    public void darDeBajaVehiculo(int id) {
        try {
            connection = con.conectar();
            String sql = "UPDATE vehiculo SET baja = true WHERE id_vehiculo = ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarRecursos(connection, preparedStatement, resultSet);
        }
    }
    
    public int ultimoId() {
    	try {
    		connection = con.conectar();
    		
            String sql = "SELECT MAX(id_vehiculo) AS max_id FROM vehiculo;";
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

