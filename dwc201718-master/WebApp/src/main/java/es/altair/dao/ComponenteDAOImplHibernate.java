package es.altair.dao;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import es.altair.bean.Componente;
import es.altair.bean.Usuario;
import es.altair.util.SessionProvider;

public class ComponenteDAOImplHibernate implements ComponenteDAO {

	public List<Componente> listar(Usuario u) {
		List<Componente> componentes = new ArrayList<Componente>();

		Session sesion = SessionProvider.getSession();
		try {
			sesion.beginTransaction();

			componentes = sesion.createQuery("FROM Componente c WHERE usuario=:usu").setParameter("usu", u).list();

			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
			// sf.close();
		}

		return componentes;
	}

	public byte[] obtenerPortadaPorId(int idComponente) {
		byte[] imagen = null;

		Session sesion = SessionProvider.getSession();
		try {
			sesion.beginTransaction();

			imagen = (byte[]) sesion.createQuery("Select c.foto From Componente c Where c.idComponente=:id")
					.setParameter("id", idComponente).uniqueResult();

			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
			// sf.close();
		}

		return imagen;
	}

	public void borrar(String uuid) {
		Session sesion = SessionProvider.getSession();
		try {
			sesion.beginTransaction();

			sesion.createQuery("DELETE FROM Componente WHERE uuid=:clave").setParameter("clave", uuid).executeUpdate();

			sesion.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			sesion.close();
			
		}
	}

	public Componente obtenerComponentePorUUID(String uuid) {
		Componente l = new Componente();

		Session sesion = SessionProvider.getSession();
		try {
			sesion.beginTransaction();

			l = (Componente) sesion.createQuery("FROM Componente l WHERE l.uuid=:clave").setParameter("clave", uuid)
					.uniqueResult();

			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
			// sf.close();
		}
		return l;
	}

	public void actualizar(String modelo, String marca, int precio, ByteArrayOutputStream os, String uuid,
			Usuario usuario) {
		Session sesion = SessionProvider.getSession();
		try {
			sesion.beginTransaction();

			if (os != null) {
				sesion.createQuery("UPDATE Componente SET modelo=:t, marca=:a, precio=:i, " 
						+ "portada=:f WHERE uuid=:clave")
						.setParameter("m", modelo)
						.setParameter("x", marca)
						.setParameter("p", precio)
						.setParameter("f", os.toByteArray())
						.setParameter("clave", uuid)
						.executeUpdate();
			} else {
				sesion.createQuery("UPDATE Componente SET modelo=:t, marca=:a, precio=:i, " 
						+ " WHERE uuid=:clave")
						.setParameter("m", modelo)
						.setParameter("x", marca)
						.setParameter("p", precio)
						.setParameter("clave", uuid)
						.executeUpdate();
			}

			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
			// sf.close();
		}
	}

	public void insertar(Componente l) {
		Session sesion = SessionProvider.getSession();
		try {
			sesion.beginTransaction();

			sesion.save(l);

			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close();
			// sf.close();
		}
	}

}
