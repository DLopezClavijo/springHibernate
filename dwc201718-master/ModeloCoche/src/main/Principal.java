package main;

import bean.ModeloCoche;
import dao.ModeloCocheDAO;
import dao.ModeloCocheImplConjuntos;
import dao.ModeloCocheImplListas;

public class Principal {

	public static void main(String[] args) {
		ModeloCocheDAO mcDAO = new ModeloCocheImplListas();
		
		//ModeloCocheDAO mcDAO = new ModeloCocheImplConjuntos();
		
		ModeloCoche m1 = new ModeloCoche(2014, 150, 20000.99, "m1", "mar1");
		ModeloCoche m2 = new ModeloCoche(2015, 160, 30000.99, "m2", "mar2");
		ModeloCoche m3 = new ModeloCoche(2016, 170, 40000.99, "m3", "mar3");
		
		ModeloCoche m4 = new ModeloCoche(2016, 170, 40000.99, "m3", "mar3");
		
		mcDAO.insertar(m1);
		mcDAO.insertar(m2);
		mcDAO.insertar(m3);
		
		mcDAO.insertar(m4);
		
		mcDAO.listar();
		
		ModeloCoche m22 = m2;
		m22.setAnyo_fab(2017);
		if (mcDAO.actualizar(m2, m22)) {
			System.out.println("ACTUALIZADO: " + m22);
		} else {
			System.out.println("NO ACTUALIZADO: " + m22);
		}
		
		mcDAO.listar();
		
		if (mcDAO.borrar(m3)) {
			System.out.println("BORRADO: " + m3);
		} else {
			System.out.println("NO BORRADO: " + m3);
		}
		
		mcDAO.listar();
	}

}
