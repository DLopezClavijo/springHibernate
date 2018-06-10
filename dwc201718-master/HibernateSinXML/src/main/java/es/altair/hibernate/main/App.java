package es.altair.hibernate.main;

import org.hibernate.Session;

import es.altair.hibernate.bean.Profesor;
import es.altair.hibernate.util.SessionProvider;

public class App {
	public static void main(String[] args) {
		
		
		// OPERACIONES
		Profesor p = new Profesor(1234789, "ProfeProfe", "ApeProfe1", "ApeProfe2");
		
		Session session = SessionProvider.getSession();
		
		session.beginTransaction();
		
		session.save(p);
		
		session.getTransaction().commit();
		
		
	}
}
