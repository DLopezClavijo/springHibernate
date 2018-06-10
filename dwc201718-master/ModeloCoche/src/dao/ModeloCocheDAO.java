package dao;

import bean.ModeloCoche;

public interface ModeloCocheDAO {

	public void insertar(ModeloCoche mc);
	public boolean actualizar(ModeloCoche mcOld, ModeloCoche mcNew);
	public boolean borrar(ModeloCoche mc);
	public void listar();
}
