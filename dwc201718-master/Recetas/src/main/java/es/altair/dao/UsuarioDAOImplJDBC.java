package es.altair.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.altair.bean.Usuario;

public class UsuarioDAOImplJDBC implements UsuarioDAO {

	public List<Usuario> listarTodos() {
		List<Usuario> usuarios = new ArrayList<Usuario>();

		ConexionDAO.abrirConexion();

		String query = "SELECT * FROM USUARIOS";
		try {
			Statement sentencia = ConexionDAO.getConexion().createStatement();
			ResultSet resultado = sentencia.executeQuery(query);
			while (resultado.next()) {
				Usuario u = new Usuario(resultado.getInt("idUsuario"), resultado.getString("nombre"),
						resultado.getString("apellidos"), resultado.getString("login"), resultado.getString("password"),
						resultado.getString("email"), resultado.getInt("tipo_acceso"), resultado.getInt("activacion"));
				usuarios.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ConexionDAO.cerrarConexion();

		return usuarios;
	}

	public boolean insertar(Usuario u) {
		int num_filas = 0;

		ConexionDAO.abrirConexion();

		String query = "INSERT INTO USUARIOS VALUES(null, ?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement sentencia = ConexionDAO.getConexion().prepareStatement(query);
			sentencia.setString(1, u.getNombre());
			sentencia.setString(2, u.getApellidos());
			sentencia.setString(3, u.getLogin());
			sentencia.setString(4, u.getPassword());
			sentencia.setString(5, u.getEmail());
			sentencia.setInt(6, u.getTipo_acceso());
			sentencia.setInt(7, u.getActivacion());

			num_filas = sentencia.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ConexionDAO.cerrarConexion();

		// return (num_filas == 0)? false: true;

		if (num_filas == 0)
			return false;
		else
			return true;
	}

	public boolean actualizar(Usuario u) {
		int num_filas = 0;

		ConexionDAO.abrirConexion();

		String query = "UPDATE USUARIOS SET nombre = ?, apellidos = ?, login = ?, "
				+ "password = ?, email = ?, tipo_acceso = ?, activacion = ? WHERE idUsuario = ?";

		try {
			PreparedStatement sentencia = ConexionDAO.getConexion().prepareStatement(query);
			sentencia.setString(1, u.getNombre());
			sentencia.setString(2, u.getApellidos());
			sentencia.setString(3, u.getLogin());
			sentencia.setString(4, u.getPassword());
			sentencia.setString(5, u.getEmail());
			sentencia.setInt(6, u.getTipo_acceso());
			sentencia.setInt(7, u.getActivacion());
			sentencia.setInt(8, u.getIdUsuario());

			num_filas = sentencia.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ConexionDAO.cerrarConexion();

		// return (num_filas == 0)? false: true;

		if (num_filas == 0)
			return false;
		else
			return true;
	}

	public Usuario obtener(int idUsuario) {
		Usuario u = null;

		ConexionDAO.abrirConexion();

		String query = "SELECT * FROM USUARIOS WHERE idUsuario = ?";

		try {
			PreparedStatement sentencia = ConexionDAO.getConexion().prepareStatement(query);
			sentencia.setInt(1, idUsuario);
			ResultSet resultado = sentencia.executeQuery();
			while (resultado.next()) {
				u = new Usuario(resultado.getInt("idUsuario"), resultado.getString("nombre"),
						resultado.getString("apellidos"), resultado.getString("login"), resultado.getString("password"),
						resultado.getString("email"), resultado.getInt("tipo_acceso"), resultado.getInt("activacion"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ConexionDAO.cerrarConexion();

		return u;
	}

	public boolean borrar(int idUsuarioB) {
		int num_filas = 0;

		ConexionDAO.abrirConexion();

		String query = "DELETE FROM USUARIOS WHERE idUsuario = ?";

		try {
			PreparedStatement sentencia = ConexionDAO.getConexion().prepareStatement(query);
			sentencia.setInt(1, idUsuarioB);

			num_filas = sentencia.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ConexionDAO.cerrarConexion();

		// return (num_filas == 0)? false: true;

		if (num_filas == 0)
			return false;
		else
			return true;
	}

	public List<Usuario> mostrarUsuariosAcceso(int tipo) {
		List<Usuario> usuarios = new ArrayList<Usuario>();

		ConexionDAO.abrirConexion();

		try {
			CallableStatement call = ConexionDAO.getConexion().prepareCall("{call mostrar_usuarios_acceso(?)}");
			call.setInt(1, tipo);
			ResultSet resultado = call.executeQuery();
			while (resultado.next()) {
				Usuario u = new Usuario(resultado.getInt("idUsuario"), resultado.getString("nombre"),
						resultado.getString("apellidos"), resultado.getString("login"), resultado.getString("password"),
						resultado.getString("email"), resultado.getInt("tipo_acceso"), resultado.getInt("activacion"));
				usuarios.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ConexionDAO.cerrarConexion();

		return usuarios;
	}

	public boolean comprobarSQL1(String login, String password) {
		boolean enc = false;

		ConexionDAO.abrirConexion();

		String query = "SELECT * FROM USUARIOS WHERE "
				+ "login = '" + login + "' AND password = '" + password + "'";
		try {
			Statement sentencia = ConexionDAO.getConexion().createStatement();
			ResultSet resultado = sentencia.executeQuery(query);
			if (resultado.next())
				enc = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ConexionDAO.cerrarConexion();

		return enc;
	}

	public boolean comprobarSQL2(String login, String password) {
		boolean enc = false;

		ConexionDAO.abrirConexion();
 
		String query = "SELECT * FROM USUARIOS WHERE login = ? AND password = ?";
		
		try {
			PreparedStatement sentencia = ConexionDAO.getConexion().prepareStatement(query);
			sentencia.setString(1, login);
			sentencia.setString(2, password);
			ResultSet resultado = sentencia.executeQuery();
			if (resultado.next())
				enc = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ConexionDAO.cerrarConexion();

		return enc;
	}

}
