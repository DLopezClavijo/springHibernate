package es.altair.dao;

import java.io.ByteArrayOutputStream;
import java.util.List;

import es.altair.bean.Libro;
import es.altair.bean.Usuario;

public interface LibroDAO {

	List<Libro> listar (Usuario u);
	
	byte[] obtenerPortadaPorId(int idLibro);

	void borrar(String uuid);
	
	Libro obtenerLibroPorUUID(String uuid);

	void actualizar(String titulo, String autor, int isbn, ByteArrayOutputStream os, String uuid, Usuario usuario);

	void insertar(Libro l);
}
