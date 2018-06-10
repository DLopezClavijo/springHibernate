package es.altair.hibernate.main;

import es.altair.hibernate.bean.Direccion;
import es.altair.hibernate.bean.Profesor;
import es.altair.hibernate.dao.ProfesorDAO;
import es.altair.hibernate.dao.ProfesorDAOImplHibernate;

public class App 
{
    public static void main( String[] args )
    {
        ProfesorDAO profDAO = new ProfesorDAOImplHibernate();
        
        Direccion dir = new Direccion(2500, "el barbero de sevilla", 6, "sevilla", "sevilla");
        Profesor prof = new Profesor(2500, "Antonio", "Prof1", "Prof2", dir);
        
        profDAO.guardar(prof);
    }
}
