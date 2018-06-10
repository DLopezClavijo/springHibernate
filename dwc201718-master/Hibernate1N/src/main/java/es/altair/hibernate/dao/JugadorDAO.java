package es.altair.hibernate.dao;

import es.altair.hibernate.bean.Jugador;

public interface JugadorDAO {

	public void save(Jugador j);

	public void update(Jugador j4);

	public Jugador get(int i);

	public void delete(Jugador j44);
}
