package es.altair.proyecto.dao;

import java.io.IOException;
import java.sql.Blob;
import java.util.List;

import org.hibernate.HibernateException;

import es.altair.proyecto.bean.Coche;
import es.altair.proyecto.bean.Usuario;

public interface CocheDAO {
	
	boolean comprobarMatricula(Coche car);
	Blob obtenerImagen(byte[] byteArray) throws HibernateException, IOException ;
	int addCar(Coche car);
	List<Coche> listarById(Usuario usu);
	List<Coche> getCarsList();
	void deleteCars(Coche car);
	int carsByUsers(int idUsu);
	Blob showImage(int idCoche);
	Coche carsById(int idCars);
	void añadirCoche(Coche car);
	int editarCars(Coche car);

}
