package es.altair.proyecto.dao;

import java.util.List;

import es.altair.proyecto.bean.Usuario;

public interface UsuarioDAO {

	boolean comprobarAlias(Usuario usu); 
	boolean comprobarCorreo(Usuario usu);
	boolean comprobarTelefono(Usuario usu); 
	int registrar(Usuario usu); 
	Usuario comprobarUsuario(String login, String password); 
	Usuario obtenerUsuPorId(int id);
	List<Usuario> getAdministrartorList();
	List<Usuario> getClientList();
	List<Usuario> getWorkersList();
	void deleteUser(int idUsu);
	int addUsers(Usuario usu);
	int editUsers(Usuario usu); 
}
