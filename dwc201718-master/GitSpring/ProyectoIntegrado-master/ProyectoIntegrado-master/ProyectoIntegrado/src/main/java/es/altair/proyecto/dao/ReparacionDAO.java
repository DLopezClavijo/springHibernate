package es.altair.proyecto.dao;

import java.util.List;

import es.altair.proyecto.bean.Reparaciones;

public interface ReparacionDAO {

	List<Reparaciones> getRepairList();

	void deleteRepair(int idRepa);

	boolean comprobarNombre(Reparaciones repa);

	int addRepair(Reparaciones repa);

	Reparaciones obtenerReparacionById(int idRepa);

	int editRepair(Reparaciones repa);

}
