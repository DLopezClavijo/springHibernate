package es.altair.springhibernate.dao;

import java.io.IOException;
import java.sql.Blob;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.altair.springhibernate.bean.Person;

@Repository
public class PersonDAOImplHibernate implements PersonDAO {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	@Override
	public List<Person> listPersons() {
		Session sesion = sessionFactory.getCurrentSession();
		return (List<Person>)sesion.createQuery("From Person").list();
	}

	@Transactional
	@Override
	public void editPerson(Person p) {
		Session sesion = sessionFactory.getCurrentSession();
		sesion.update(p);
	}

	@Transactional
	@Override
	public void addPerson(Person p) {
		Session sesion = sessionFactory.getCurrentSession();
		sesion.persist(p);
	}

	@Transactional
	@Override
	public Person getPersonById(int id) {
		Session sesion = sessionFactory.getCurrentSession();
		return (Person)sesion.get(Person.class, id);
	}

	@Transactional
	@Override
	public void deletePerson(int id) {
		Session sesion = sessionFactory.getCurrentSession();
		sesion.delete(getPersonById(id));
	}

	@Transactional
	@Override
	public Blob obtenerImagen(int id) {
		Blob image = null;
		Session session = sessionFactory.getCurrentSession();
		image = (Blob) session.createQuery("SELECT p.imagen FROM Person p WHERE p.id=:id")
				.setParameter("id", id).uniqueResult();
		return image;
	}
	
	@Transactional
	@Override
	public Blob obtenerBlobFromFile(byte[] bs) throws HibernateException, IOException {
		return Hibernate.getLobCreator(sessionFactory.getCurrentSession()).createBlob(bs);
	}

}
