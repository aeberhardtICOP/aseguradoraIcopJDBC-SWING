package Service;
import Persistence.UserPswdPersistence;
public class UserPswdService {
	 UserPswdPersistence bd = new UserPswdPersistence();
	 public boolean validacionLogin(String user, String pass) {
		
		 return bd.buscarUsuario(user, pass);
	 }
	 public void crearUsuario(String user, String pass) {
		 bd.crearUsuaio(user, pass);
	 }
	 public boolean existeUsuario(String user) {
		 return bd.existeUsuario(user);
	 }
	 public void editarContraseña(String user, String pass) {
		 bd.editarContraseña(user, pass);
	 }
}
