package es.altair.proyecto.dao;

import java.io.IOException;
import java.sql.Blob;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import es.altair.proyecto.bean.Coche;
import es.altair.proyecto.bean.Usuario;

public class CocheDAOImpl implements CocheDAO {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	@Override
	public boolean comprobarMatricula(Coche car) {
		boolean correcto = false; 
		
		Session sesion = sessionFactory.getCurrentSession(); 

		Coche coche = (Coche) sesion.createQuery("FROM Coche WHERE matricula =:m")
				.setParameter("m", car.getMatricula().toUpperCase())
				.uniqueResult();
		if(coche != null)
			correcto = true; 
		else
			correcto = false; 
		return correcto;
	}
	@Transactional
	@Override
	public Blob obtenerImagen(byte[] bs) throws HibernateException, IOException {
		return Hibernate.getLobCreator(sessionFactory.getCurrentSession()).createBlob(bs);
	}
	@Transactional
	@Override
	public int addCar(Coche car) {
		int filas = 0;
		System.out.println("entra AddCar");
		System.out.println("idUsuario" + car.getUsuario().getIdUsuario());
		Session sesion = sessionFactory.getCurrentSession();  
		filas = sesion.createSQLQuery("INSERT INTO coches(matricula, marca, modelo, usuarioId, anyo, motor, potencia) values (:m, :ma, :mo, :u, :a, :mot, :p)")
				.setParameter("m", car.getMatricula())
				.setParameter("ma", car.getMarca())
				.setParameter("mo", car.getModelo())
				.setParameter("u", car.getUsuario().getIdUsuario())
				.setParameter("a", car.getAnyo())
				.setParameter("mot", car.getMotor())
				.setParameter("p", car.getPotencia())
				.executeUpdate(); 
		return filas;
	}
	@Transactional
	@Override
	public List<Coche> listarById(Usuario usu) {
		Session sesion = sessionFactory.getCurrentSession(); 
		List<Coche> lista = sesion.createQuery("FROM Coche c WHERE usuario=:u")
				.setParameter("u", usu)
				.list(); 
		return lista;
	}
	@Transactional
	@Override
	public List<Coche> getCarsList() {
		Session sesion = sessionFactory.getCurrentSession(); 
		List<Coche> lista = sesion.createQuery("FROM Coche c")
				.list(); 
		return lista;
	}
	@Transactional
	@Override
	public void deleteCars(Coche c) {
		Session sesion = sessionFactory.getCurrentSession(); 
		sesion.delete(c);
		/*sesion.createQuery("DELETE FROM Coche WHERE usuarioId =:u")
			.setParameter("u",  idUsuario)
			.executeUpdate();*/ 
		
	}

	@Override
	public int carsByUsers(int idUsu) {
		int num = 0; 
		
		return 0;
	}
	@Transactional
	@Override
	public Blob showImage(int idCoche) {
		System.out.println("showImagen id: " + idCoche);
		Blob image = null;
		Session session = sessionFactory.getCurrentSession(); 
		image = (Blob) session.createQuery("SELECT fichaTecnica FROM Coche  WHERE idCoche=:id")
				.setParameter("id", idCoche).uniqueResult(); 
		
		
		return image;
	}
	@Transactional
	@Override
	public Coche carsById(int idCars) {
		Coche car = null; 
		Session sesion = sessionFactory.getCurrentSession();
		car = (Coche) sesion.createQuery("FROM Coche WHERE idCoche=:i")
				.setParameter("i", idCars)
				.uniqueResult(); 
		System.out.println("AÑO "+car.getAnyo());
		return car;
	}

	@Transactional
	@Override
	public void añadirCoche(Coche car) {
		Session sesion = sessionFactory.getCurrentSession();
		sesion.persist(car);
	}
	
	@Transactional
	@Override
	public int editarCars(Coche car) {
		int filas = 0; 
		Session sesion = sessionFactory.getCurrentSession(); 
		System.out.println("cocheID: " + car.getIdCoche());
		filas = sesion.createQuery("UPDATE Coche SET matricula=:m, marca=:ma , modelo=:mo , anyo=:a, motor=:mot, potencia=:p WHERE idCoche=:id")
				.setParameter("id", car.getIdCoche())
				.setParameter("m", car.getMatricula())
				.setParameter("ma", car.getMarca())
				.setParameter("mo", car.getModelo())
				.setParameter("a", car.getAnyo())
				.setParameter("mot", car.getMotor())
				.setParameter("p", car.getPotencia())
				.executeUpdate();
		return filas;  

	}
	

}
