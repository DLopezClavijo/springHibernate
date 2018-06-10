package es.altair.hibernate.main;

import java.util.Date;

import es.altair.hibernate.bean.Grupo;
import es.altair.hibernate.bean.Usuario;
import es.altair.hibernate.bean.UsuarioGrupo;
import es.altair.hibernate.dao.UsuarioGrupoDAO;
import es.altair.hibernate.dao.UsuarioGrupoDAOImplHibernate;

public class App 
{
    public static void main( String[] args )
    {
        UsuarioGrupoDAO ugDAO = new UsuarioGrupoDAOImplHibernate();
        
        Usuario u1 = new Usuario("u1", "123456789", "u1@u1.com");
        Grupo g1 = new Grupo("g1");
        
        UsuarioGrupo ug = new UsuarioGrupo(u1, g1, true, new Date());
        
        ugDAO.save(ug);
    }
}
