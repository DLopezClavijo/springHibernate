package es.altair.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import es.altair.bean.Profesor;

public class App {
	public static void main(String[] args) {
		SessionFactory sessionFactory;

		StandardServiceRegistry stR = new StandardServiceRegistryBuilder()
				.configure("hibernate.cfg.xml").build();
		
		Metadata mt = new MetadataSources(stR).getMetadataBuilder().build();
		
		sessionFactory = mt.getSessionFactoryBuilder().build();
		
		Session sesion = sessionFactory.openSession();
		
		// OPERACIONES
		Profesor p = new Profesor(1234, "ProfeProfe", "ApeProfe1", "ApeProfe2");
		
//		sesion.beginTransaction();
//		sesion.save(p);
//		sesion.getTransaction().commit();
		
		Profesor aux = (Profesor)sesion.get(Profesor.class, 1234);
		System.out.println(aux);

//		aux.setNombre("NombreAUXProfe");
//		sesion.beginTransaction();
//		sesion.update(aux);
//		sesion.getTransaction().commit();
		
		sesion.beginTransaction();
		sesion.delete(aux);
		sesion.getTransaction().commit();
		
		sesion.close();
		
		sessionFactory.close();
	}
}
