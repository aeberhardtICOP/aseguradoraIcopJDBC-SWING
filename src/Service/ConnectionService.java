package Service;

import Persistence.Conection;

public class ConnectionService {
	Conection con = new Conection();
	public boolean pingConection(String user, String pass) {
		return con.ping(user, pass);
	}
	public boolean Conectar(String user, String pass) {
		if(con.ping(user, pass)==true) {
			con.setUsuario(user);
			con.setContraseña(pass);
			return true;
		}else {
			return false;
		}
	}
	
}
