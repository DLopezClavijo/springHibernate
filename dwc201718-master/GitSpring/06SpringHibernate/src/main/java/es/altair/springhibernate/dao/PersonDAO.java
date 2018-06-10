package es.altair.springhibernate.dao;

import java.io.IOException;
import java.sql.Blob;
import java.util.List;

import org.hibernate.HibernateException;

import es.altair.springhibernate.bean.Person;

public interface PersonDAO {

	public List<Person> listPersons();
	
	public void editPerson(Person p);
	
	public void addPerson(Person p);
	
	public Person getPersonById(int id);
	
	public void deletePerson(int id);

	public Blob obtenerImagen(int i);
	
	public Blob obtenerBlobFromFile(byte[] bs) throws HibernateException, IOException;
}
