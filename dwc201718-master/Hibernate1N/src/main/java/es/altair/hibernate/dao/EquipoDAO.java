package es.altair.hibernate.dao;

import es.altair.hibernate.bean.Equipo;

public interface EquipoDAO {

	public void save(Equipo e);

	public Equipo get(int i);

	public void delete(Equipo e1);
}
