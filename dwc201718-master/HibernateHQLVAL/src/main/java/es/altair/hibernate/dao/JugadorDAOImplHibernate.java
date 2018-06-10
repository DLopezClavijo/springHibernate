package es.altair.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import es.altair.hibernate.bean.Jugador;

public class JugadorDAOImplHibernate implements JugadorDAO {

	public List<Jugador> listado() {
		List<Jugador> jugadores = new ArrayList<Jugador>();

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {
			sesion.beginTransaction();
			jugadores = sesion.createSQLQuery("SELECT * FROM jugador").addEntity(Jugador.class).list();
			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
			sf.close();
		}

		return jugadores;
	}

	public void mostrarJugadoresPaginacion(int tamanyoPagina) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();

		try {
			sesion.beginTransaction();

			long numJugadores = (Long) sesion.createQuery("SELECT count(*) FROM Jugador j")
					.uniqueResult();
			int numPaginas = (int) Math.ceil(numJugadores/tamanyoPagina);
			
			Query query = (Query) sesion.createQuery("FROM Jugador j ORDER BY j.nombre")
					.setMaxResults(tamanyoPagina);
			
			for (int i = 0; i < numPaginas; i++) {
				System.out.println("-- Página " + (i + 1) + " --");
				query.setFirstResult(i*tamanyoPagina);
				List<Jugador> jugadores = query.list();
				for (Jugador jugador : jugadores) {
					System.out.println(jugador);
				}
			}

			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
			sf.close();
		}
	}

}
