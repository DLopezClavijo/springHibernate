package es.altair.hibernate.main;

import es.altair.hibernate.bean.Direccion;
import es.altair.hibernate.bean.Profesor;
import es.altair.hibernate.dao.DireccionDAO;
import es.altair.hibernate.dao.DireccionDAOImplHibernate;
import es.altair.hibernate.dao.ProfesorDAO;
import es.altair.hibernate.dao.ProfesorDAOImplHibernate;

public class App 
{
    public static void main( String[] args )
    {
        ProfesorDAO profDAO = new ProfesorDAOImplHibernate();
        DireccionDAO dirDAO = new DireccionDAOImplHibernate();
        
        Direccion dir1 = new Direccion(3000, "calle 3000", 3000, "sevilla", "sevilla");
        Profesor prof1 = new Profesor(3000, "prof 3000", "ape1 3000", "ape2 3000");
        dir1.setProfesor(prof1);
        prof1.setDireccion(dir1);
        
        Direccion dir2 = new Direccion(4000, "calle 4000", 4000, "sevilla", "sevilla");
        Profesor prof2 = new Profesor(4000, "prof 4000", "ape1 4000", "ape2 4000");
        dir2.setProfesor(prof2);
        prof2.setDireccion(dir2);
        
        profDAO.guardar(prof1);
        dirDAO.guardar(dir2);
    }
}
