package es.altair.hibernate.main;

import java.util.ArrayList;
import java.util.List;

import es.altair.hibernate.bean.Equipo;
import es.altair.hibernate.bean.Jugador;
import es.altair.hibernate.dao.EquipoDAO;
import es.altair.hibernate.dao.EquipoDAOImplHibernate;
import es.altair.hibernate.dao.JugadorDAO;
import es.altair.hibernate.dao.JugadorDAOImplHibernate;

public class App {
	public static void main(String[] args) {
		EquipoDAO eDAO = new EquipoDAOImplHibernate();
		JugadorDAO jDAO = new JugadorDAOImplHibernate();
		
		List<Equipo> equipos = new ArrayList<Equipo>();
		List<Object[]> equiposNS = new ArrayList<Object[]>();
		List<Jugador> jugadores = new ArrayList<Jugador>();

//		System.out.println("LISTADO DE EQUIPOS");
//		equipos = eDAO.listado();
//		for (Equipo equipo : equipos) {
//			System.out.println(equipo);
//		}
		
//		System.out.println("LISTADO DE EQUIPOS (NOMBRE Y NÚMERO DE SOCIOS");
//		equipos = eDAO.listadoNombreySocios();
//		for (Equipo equipo : equipos) {
//			System.out.println(equipo.getNombre() + ", " + equipo.getNumSocios());
//		}
//		for (Object[] objects : equiposNS) {
//			System.out.println(objects[0] + ", " + objects[1]);
//		}
		
//		System.out.println("OBTENER UN EQUIPO POR ID");
//		System.out.println(eDAO.obtener(2));
		
//		System.out.println("OBTENER UN EQUIPO POR CIUDAD Y SOCIOS");
//		System.out.println(eDAO.obtenerCS("Sevilla", 50000));
		
//		System.out.println("LISTADO DE JUGADORES EN SQL");
//		jugadores = jDAO.listado();
//		for (Jugador jugador : jugadores) {
//			System.out.println(jugador);
//		}
		
//		System.out.println("LISTADO DE EQUIPOS CON MÁS DE 45000 SOCIOS");
//		equipos = eDAO.listadoPorSocios(45000);
//		for (Equipo equipo : equipos) {
//			System.out.println(equipo.getNombre() + ", " + equipo.getNumSocios());
//		}
		
//		System.out.println("LISTADO PAGINADO DE JUGADORES");
//		jDAO.mostrarJugadoresPaginacion(3);
		
		Equipo eq = new Equipo("EquipoVAL", "Sevilla", 1000000);
		eDAO.guardar(eq);
	}
}
