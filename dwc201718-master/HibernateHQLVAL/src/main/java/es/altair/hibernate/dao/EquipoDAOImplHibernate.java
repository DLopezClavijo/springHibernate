package es.altair.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import es.altair.hibernate.bean.Equipo;

public class EquipoDAOImplHibernate implements EquipoDAO {

	public List<Equipo> listado() {
		List<Equipo> equipos = new ArrayList<Equipo>();

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {
			sesion.beginTransaction();
			equipos = sesion.createQuery("FROM Equipo").list();
			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
			sf.close();
		}

		return equipos;
	}

	public List<Equipo> listadoNombreySocios() {
		List<Equipo> equipos = new ArrayList<Equipo>();

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {
			sesion.beginTransaction();
			equipos = sesion.createQuery("SELECT new Equipo(e.nombre, e.numSocios) FROM Equipo e").list();
			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
			sf.close();
		}

		return equipos;
	}

	public Equipo obtener(int i) {
		Equipo eq = null;
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {
			sesion.beginTransaction();

//			eq = (Equipo) sesion.createQuery("FROM Equipo WHERE idEquipo=" + i)
//					.uniqueResult();
			
			eq = (Equipo) sesion.createQuery("FROM Equipo WHERE idEquipo=:id")
					.setParameter("id", i).uniqueResult();
			
			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
			sf.close();
		}
		
		return eq;
	}

	public Equipo obtenerCS(String ciudad, int numSocios) {
Equipo eq = null;
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {
			sesion.beginTransaction();

//			eq = (Equipo) sesion.createQuery("FROM Equipo WHERE idEquipo=" + i)
//					.uniqueResult();
			
			eq = (Equipo) sesion.createQuery("FROM Equipo WHERE ciudad=:ci AND numSocios=:ns")
					.setParameter("ci", ciudad)
					.setParameter("ns", numSocios)
					.uniqueResult();
			
			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
			sf.close();
		}
		
		return eq;
	}

	public List<Equipo> listadoPorSocios(int num) {
		List<Equipo> equipos = new ArrayList<Equipo>();

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {
			sesion.beginTransaction();
			equipos = sesion.createCriteria(Equipo.class)
					.add(Restrictions.gt("numSocios", num))
					.addOrder(Order.desc("numSocios"))
					.list();
			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
			sf.close();
		}

		return equipos;
	}

	public void guardar(Equipo eq) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {
			sesion.beginTransaction();
			
			sesion.save(eq);
			
			sesion.getTransaction().commit();
		} catch (ConstraintViolationException e) {
			sesion.getTransaction().rollback();
			System.out.println("-- ERRORES --");
			for (ConstraintViolation cv : e.getConstraintViolations()) {
				System.out.println("Campo: " + cv.getPropertyPath());
				System.out.println("Mensaje: " + cv.getMessage());
			}
		} finally {
			sesion.close();
			sf.close();
		}
	}

}
