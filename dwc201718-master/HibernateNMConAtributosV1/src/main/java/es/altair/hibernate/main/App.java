package es.altair.hibernate.main;

import java.util.Date;

import es.altair.hibernate.bean.Grupo;
import es.altair.hibernate.bean.Usuario;
import es.altair.hibernate.bean.UsuarioGrupo;
import es.altair.hibernate.dao.GrupoDAO;
import es.altair.hibernate.dao.GrupoDAOImplHibernate;
import es.altair.hibernate.dao.UsuarioDAO;
import es.altair.hibernate.dao.UsuarioDAOImplHibernate;

public class App 
{
	public static void main(String[] args) {
		GrupoDAO gDAO = new GrupoDAOImplHibernate();
		UsuarioDAO uDAO = new UsuarioDAOImplHibernate();
		
		Usuario u1 = new Usuario("u1", "123456789", "u1@u1.com");
		Grupo g1 = new Grupo("g1");
		
		UsuarioGrupo usugru = new UsuarioGrupo();
		usugru.setUsuario(u1);
		usugru.setGrupo(g1);
		usugru.setActivado(true);
		usugru.setFecha_registro(new Date());
		
		u1.getUsuariosgrupos().add(usugru);
		g1.getUsuariosgrupos().add(usugru);
		
		gDAO.save(g1);
		uDAO.save(u1);

	}
}
