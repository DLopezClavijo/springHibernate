package es.altair.proyecto.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import es.altair.proyecto.bean.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO {

	private String pass = "Usuario1234$%";
	private SessionFactory sessionFactory;
		
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	@Override
	public boolean comprobarAlias(Usuario usu) {
		boolean correcto = false; 
		
		Session sesion = sessionFactory.getCurrentSession(); 
		
		Usuario u =(Usuario) sesion.createQuery("FROM Usuario WHERE alias=:a")
				.setParameter("a", usu.getAlias())
				.uniqueResult();
		
		if( u != null)
			correcto = true; 
		else 
			correcto = false; 
		
		return correcto;
	}
	@Transactional
	@Override
	public boolean comprobarCorreo(Usuario usu) {
		boolean correcto = false; 
		
		Session sesion = sessionFactory.getCurrentSession(); 
		
		Usuario u =(Usuario) sesion.createQuery("FROM Usuario WHERE correo=:c")
				.setParameter("c", usu.getCorreo())
				.uniqueResult();
		
		if( u != null)
			correcto = true; 
		else 
			correcto = false; 
		
		return correcto;
	}
	@Transactional
	@Override
	public boolean comprobarTelefono(Usuario usu) {
		boolean correcto = false; 
		
		Session sesion = sessionFactory.getCurrentSession(); 
		
		Usuario u =(Usuario) sesion.createQuery("FROM Usuario WHERE telefono=:t")
				.setParameter("t", usu.getTelefono())
				.uniqueResult();
		
		if( u != null)
			correcto = true; 
		else 
			correcto = false; 
		
		return correcto;
	}
	
	@Transactional
	@Override
	public int registrar(Usuario usu) {
		int filas = 0; 
		Session sesion=sessionFactory.getCurrentSession();
		System.out.println(usu);
		usu.setTipo(2);
		filas = sesion.createSQLQuery("INSERT INTO usuarios(nombre, apellido, alias, password, tipo, correo, telefono) values (:n, :a, :al,  AES_ENCRYPT(:p, :passphrase), :t, :c, :tlfn)")
				.setParameter("n", usu.getNombre())
				.setParameter("a", usu.getApellido())
				.setParameter("al", usu.getAlias())
				.setParameter("p", usu.getPassword())
				.setParameter("passphrase", pass)			
				.setParameter("t", usu.getTipo())
				.setParameter("c", usu.getCorreo())
				.setParameter("tlfn", usu.getTelefono())
				.executeUpdate();
		
		return filas;
	}
	@Transactional
	@Override
	public Usuario comprobarUsuario(String login, String password) {
		Session sesion = sessionFactory.getCurrentSession();	
		Usuario usu = null;
		usu = (Usuario) sesion.createQuery("SELECT u FROM Usuario u WHERE alias=:a " 
		        + "AND password=AES_ENCRYPT(:p, :passphrase)")
				.setParameter("a", login)
				.setParameter("p", password)
				.setParameter("passphrase", pass)
				.uniqueResult();
		
		return usu;
	}
	@Transactional
	@Override
	public Usuario obtenerUsuPorId(int id) {
		Usuario usu = null; 
		Session sesion = sessionFactory.getCurrentSession(); 
		
		usu =(Usuario) sesion.createQuery("FROM Usuario WHERE idUsuario=:i")
				.setParameter("i", id)
				.uniqueResult();
		return usu;
	}
	@Transactional
	@Override
	public List<Usuario> getAdministrartorList() {
		Session sesion = sessionFactory.getCurrentSession(); 
		List<Usuario> lista = sesion.createQuery("FROM Usuario u WHERE tipo=:t")
				.setParameter("t", 0)
				.list(); 
		return lista;
	}
	@Transactional
	@Override
	public List<Usuario> getClientList() {
		Session sesion = sessionFactory.getCurrentSession(); 
		List<Usuario> lista = sesion.createQuery("FROM Usuario u WHERE tipo=:t")
				.setParameter("t", 2)
				.list(); 
		return lista;
	}
	@Transactional
	@Override
	public List<Usuario> getWorkersList() {
		Session sesion = sessionFactory.getCurrentSession(); 
		List<Usuario> lista = sesion.createQuery("FROM Usuario u WHERE tipo=:t")
				.setParameter("t", 1)
				.list(); 
		return lista;
	}
	@Transactional
	@Override
	public void deleteUser(int idUsu) {
		Session sesion = sessionFactory.getCurrentSession(); 
		sesion.createQuery("DELETE FROM Usuario WHERE idUsuario =:i")
			.setParameter("i", idUsu)
			.executeUpdate(); 
	}

	@Transactional
	@Override
	public int addUsers(Usuario usu) {
		int filas = 0; 
		Session sesion=sessionFactory.getCurrentSession();
		System.out.println(usu);
		usu.setPassword("pass123$%");
		filas = sesion.createSQLQuery("INSERT INTO usuarios(nombre, apellido, alias, password, tipo, correo, telefono) values (:n, :a, :al,  AES_ENCRYPT(:p, :passphrase), :t, :c, :tlfn)")
				.setParameter("n", usu.getNombre())
				.setParameter("a", usu.getApellido())
				.setParameter("al", usu.getAlias())
				.setParameter("p", usu.getPassword())
				.setParameter("passphrase", pass)			
				.setParameter("t", usu.getTipo())
				.setParameter("c", usu.getCorreo())
				.setParameter("tlfn", usu.getTelefono())
				.executeUpdate();
		System.out.println(filas);
		return filas;
	}
	@Transactional
	@Override
	public int editUsers(Usuario usu) {
		int filas = 0; 
		Session sesion = sessionFactory.getCurrentSession(); 
		filas = sesion.createQuery("UPDATE Usuario SET nombre=:n, apellidos=:a, usuario=:u, correo=:c, telefono=:t WHERE idUsuario=:i")
					.setParameter("i", usu.getIdUsuario())
					.setParameter("n", usu.getNombre())
					.setParameter("a", usu.getApellido())
					.setParameter("u", usu.getAlias())
					.setParameter("c", usu.getCorreo())
					.setParameter("t", usu.getTelefono())
					.executeUpdate();
		return filas;  
	}
}

	
