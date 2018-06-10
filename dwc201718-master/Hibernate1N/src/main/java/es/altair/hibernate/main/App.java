package es.altair.hibernate.main;

import java.util.HashSet;
import java.util.Set;

import es.altair.hibernate.bean.Equipo;
import es.altair.hibernate.bean.Jugador;
import es.altair.hibernate.dao.EquipoDAO;
import es.altair.hibernate.dao.EquipoDAOImplHibernate;
import es.altair.hibernate.dao.JugadorDAO;
import es.altair.hibernate.dao.JugadorDAOImplHibernate;

public class App 
{
    public static void main( String[] args )
    {
        EquipoDAO eDAO = new EquipoDAOImplHibernate();
        JugadorDAO jDAO = new JugadorDAOImplHibernate();
        
        Equipo e1 = new Equipo("e1", "Sevilla", 50000);
        
        Jugador j1 = new Jugador("j1", "Defensa", e1);
        Jugador j2 = new Jugador("j2", "Medio", e1);
        Jugador j3 = new Jugador("j3", "Delantero", e1);
        
        Set<Jugador> jugadores = new HashSet<Jugador>();
        jugadores.add(j1);
        jugadores.add(j2);
        jugadores.add(j3);
        e1.setJugadores(jugadores);
        
        // SAVE Equipo
        //eDAO.save(e1);
        
        // SAVE Jugador
        Equipo e2 = eDAO.get(8);
        System.out.println(e2);
        Jugador j4 = new Jugador("j4", "Defensa", e2);
//        jDAO.save(j4);
        
        // UPDATE Jugador
//        Jugador j44 = jDAO.get(21);        
//        j44.setNombre("j44");
//        System.out.println(j44);
        //jDAO.update(j44);
        
        // DELETE Jugador
        //jDAO.delete(j44);
        
        // DELETE Equipo
        eDAO.delete(e2);
    }
}
