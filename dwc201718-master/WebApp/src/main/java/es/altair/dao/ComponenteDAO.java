package es.altair.dao;

import java.io.ByteArrayOutputStream;
import java.util.List;

import es.altair.bean.Componente;
import es.altair.bean.Usuario;

public interface ComponenteDAO {

	List<Componente> listar (Usuario u);
	
	byte[] obtenerPortadaPorId(int idComponente);

	void borrar(String uuid);
	
	Componente obtenerLibroPorUUID(String uuid);

	void actualizar(String titulo, String autor, int isbn, ByteArrayOutputStream os, String uuid, Usuario usuario);

	void insertar(Componente l);
}
