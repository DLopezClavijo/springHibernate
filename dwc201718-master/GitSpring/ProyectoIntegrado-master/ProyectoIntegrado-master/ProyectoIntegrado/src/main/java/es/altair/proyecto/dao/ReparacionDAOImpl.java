package es.altair.proyecto.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import es.altair.proyecto.bean.Reparaciones;

public class ReparacionDAOImpl implements ReparacionDAO {

private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	@Override
	public List<Reparaciones> getRepairList() {
		Session sesion = sessionFactory.getCurrentSession(); 
		List<Reparaciones> list = sesion.createQuery("FROM Reparaciones r").list(); 
		return list;
	}
	
	@Transactional
	@Override
	public void deleteRepair(int idRepa) {
		System.out.println("entrar en deleteRepair");
		Session sesion = sessionFactory.getCurrentSession(); 
		sesion.createSQLQuery("DELETE FROM reparaciones WHERE idReparaciones =:i")
			.setParameter("i", idRepa)
			.executeUpdate(); 
	}
	
	@Transactional
	@Override
	public boolean comprobarNombre(Reparaciones repa) {
		System.out.println(repa.getNombre());
		boolean correcto = false; 
		Session sesion = sessionFactory.getCurrentSession(); 

		Reparaciones r = (Reparaciones)sesion.createQuery("FROM Reparaciones WHERE nombre=:n")
				.setParameter("n", repa.getNombre())
				.uniqueResult(); 
		
		if( r != null)
			correcto = true; 
		else 
			correcto = false; 
		
		return correcto;
	}
	
	@Transactional
	@Override
	public int addRepair(Reparaciones repa) {
		
		int filas = 0; 
		Session sesion=sessionFactory.getCurrentSession();				
		
		filas = sesion.createSQLQuery("INSERT INTO reparaciones(nombre)values(:n)")
				.setParameter("n", repa.getNombre())
				.executeUpdate(); 
		return filas;

	}
	
	@Transactional
	@Override
	public Reparaciones obtenerReparacionById(int idRepa) {
		Reparaciones repa = null; 
		
		Session sesion = sessionFactory.getCurrentSession(); 
		repa = (Reparaciones) sesion.createQuery("FROM Reparaciones WHERE idReparaciones=:i")
				.setParameter("i", idRepa)
				.uniqueResult(); 
		
		return repa;
	}
	
	@Transactional
	@Override
	public int editRepair(Reparaciones repa) {
		int filas = 0; 
		Session sesion = sessionFactory.getCurrentSession(); 
		filas = sesion.createQuery("UPDATE Reparaciones SET nombre=:n WHERE idReparaciones=:i")
				.setParameter("n", repa.getNombre())
				.setParameter("i", repa.getIdReparacion())
				.executeUpdate(); 
		return filas;  
	}

	
	
}
