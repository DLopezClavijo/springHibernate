package es.altair.proyecto.dao;

import java.util.List;

import es.altair.proyecto.bean.Coche;
import es.altair.proyecto.bean.Revisiones;

public interface RevisionDAO {

	List<Revisiones> getRevisionsList();

	List<Revisiones> getRevisionsByCars(Coche cars);

	Revisiones getRevisionById(int id);

	int editRevisions(Revisiones revi);

	int addRevisions(Revisiones revi);

	void deleteRevisions(int idRevi);

	void deleteRevisionByCars(Coche car);
	


}
