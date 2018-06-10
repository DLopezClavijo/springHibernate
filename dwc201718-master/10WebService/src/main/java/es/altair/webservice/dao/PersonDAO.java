package es.altair.webservice.dao;

import java.io.IOException;
import java.sql.Blob;
import java.util.List;

import org.hibernate.HibernateException;

import es.altair.webservice.bean.Person;

public interface PersonDAO {

	public List<Person> listPersons();
	
	public void editPerson(Person p);
	
	public void addPerson(Person p);
	
	public Person getPersonById(int id);
	
	public void deletePerson(int id);
}
