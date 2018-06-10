package es.altair.hibernate.dao;

import java.util.List;

import es.altair.hibernate.bean.Equipo;

public interface EquipoDAO {

	List<Equipo> listado();

	List<Equipo> listadoNombreySocios();

	Equipo obtener(int i);

	Equipo obtenerCS(String ciudad, int numSocios);

	List<Equipo> listadoPorSocios(int numSocios);

	void guardar(Equipo eq);

}
