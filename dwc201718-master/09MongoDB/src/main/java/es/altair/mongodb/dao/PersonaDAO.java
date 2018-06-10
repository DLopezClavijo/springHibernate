package es.altair.mongodb.dao;

import java.util.List;

import es.altair.mongodb.bean.Persona;

public interface PersonaDAO {

	public void anadir(Persona p);
	
	public List<Persona> listado();
	
	public void borrar(Persona p);
	
	public void actualizar(Persona p);
	
	public Persona obtener(String id);
}
