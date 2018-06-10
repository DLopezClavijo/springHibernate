package dao;

import bean.Palabra;

public interface DiccionarioDAO {

	public void anadir(Palabra p);
	public Boolean borrar(Palabra p);
	public Boolean buscar(Palabra p);
	public String obtenerDefinicion(String palabra);
	public void listar();

}
