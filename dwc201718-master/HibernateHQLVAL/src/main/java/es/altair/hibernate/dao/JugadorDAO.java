package es.altair.hibernate.dao;

import java.util.List;

import es.altair.hibernate.bean.Jugador;

public interface JugadorDAO {

	List<Jugador> listado();

	void mostrarJugadoresPaginacion(int i);

}
