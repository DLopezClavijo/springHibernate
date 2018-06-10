package dao;

import bean.Producto;

public interface ProductoDAO {

	public void anadir(Producto p);
	public Boolean borrar(Integer codigo);
	public Boolean actualizar(Producto p);
	public void listar();
	public void borrarTodos();
	
	public void generarFichero(String nombreFichero);
	public void recuperarFichero(String nombreFichero);
}
