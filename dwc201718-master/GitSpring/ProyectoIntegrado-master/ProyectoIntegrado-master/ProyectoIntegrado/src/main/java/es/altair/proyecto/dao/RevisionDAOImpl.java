package es.altair.proyecto.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import es.altair.proyecto.bean.Coche;
import es.altair.proyecto.bean.Revisiones;

public class RevisionDAOImpl implements RevisionDAO {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	@Override
	public List<Revisiones> getRevisionsList() {
		Session sesion = sessionFactory.getCurrentSession(); 
		List<Revisiones> lista = sesion.createQuery("FROM Revisiones r").list(); 
		return lista;
	}

	@Transactional
	@Override
	public List<Revisiones> getRevisionsByCars(Coche car) {
		Session sesion = sessionFactory.getCurrentSession(); 
		List<Revisiones> lista = sesion.createQuery("FROM Revisiones r WHERE coche=:c")
				.setParameter("c", car)
				.list(); 
		return lista;
	}
	
	@Transactional
	@Override
	public Revisiones getRevisionById(int id) {
		Revisiones r = null; 
		Session sesion = sessionFactory.getCurrentSession(); 

			r =  (Revisiones) sesion.createQuery("FROM Revisiones WHERE idRevision=:i")
					.setParameter("i", id)
					.uniqueResult(); 
		return r;
	}

	@Transactional
	@Override
	public int editRevisions(Revisiones revi) {
		int filas = 0; 
		Session sesion = sessionFactory.getCurrentSession(); 
		
		//filas = sesion.createQuery("UPDATE Revisiones SET fecha=:f, kilometros=:k, reparacion WHERE idRevision=:i")
		return filas;
	}
	
	@Transactional
	@Override 
	public int addRevisions(Revisiones revi) {
		System.out.println("idCoche: " + revi.getCoche().getIdCoche());
		int filas = 0;
		Session sesion = sessionFactory.getCurrentSession();  		
		filas= sesion.createSQLQuery("INSERT INTO revisiones(fecha, kilometros,observaciones, idCoche, idReparacion, precio) values (:f, :k, :o, :ic, :ir, :p) ")
				.setParameter("f", revi.getFecha())
				.setParameter("k", revi.getKilometros())
				.setParameter("o", revi.getObservaciones())
				.setParameter("ic", revi.getCoche().getIdCoche())
				.setParameter("ir", revi.getReparacion().getIdReparacion())
				.setParameter("p", revi.getPrecio())
				.executeUpdate();
		return filas;
	}

	@Transactional
	@Override
	public void deleteRevisions(int idRevi) {
		Session sesion = sessionFactory.getCurrentSession(); 
		sesion.createQuery("DELETE FROM Revisiones WHERE idRevision =:i")
			.setParameter("i", idRevi)
			.executeUpdate(); 
	}
	
	@Transactional
	@Override
	public void deleteRevisionByCars(Coche c) {
		System.out.println("ID COCHES: " + c.getIdCoche());
		Session sesion = sessionFactory.getCurrentSession(); 
		sesion.createSQLQuery("DELETE FROM revisiones WHERE idCoche =:i")
			.setParameter("i", c.getIdCoche())
			.executeUpdate(); 
		
	}
	
	
}
