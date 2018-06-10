package es.altair.dao;

import java.util.List;

import es.altair.bean.Usuario;

public interface UsuarioDAO {

	public List<Usuario> listarTodos();

	public boolean insertar(Usuario u);

	public boolean actualizar(Usuario u);

	public Usuario obtener(int idUsuario);

	public boolean borrar(int idUsuarioB);
	
	public List<Usuario> mostrarUsuariosAcceso(int tipo);
	
	public boolean comprobarSQL1(String login, String password);
	
	public boolean comprobarSQL2(String login, String password);
}
