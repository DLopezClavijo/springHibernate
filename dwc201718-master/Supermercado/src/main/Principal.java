package main;

import bean.Producto;
import dao.ProductoDAO;
import dao.ProductoDAOImplMap;

public class Principal {

	public static void main(String[] args) {
		ProductoDAO proDAO = new ProductoDAOImplMap();
		
		Producto p1 = new Producto(1, 20.30, "p1");
		Producto p2 = new Producto(2, 30.40, "p2");
		Producto p3 = new Producto(3, 40.50, "p3");
		
		proDAO.anadir(p1);
		proDAO.anadir(p2);
		proDAO.anadir(p3);
		
		System.out.println("-- LISTA AÑADIR --");
		proDAO.listar();
		System.out.println("-- FIN LISTA --");
		
		proDAO.borrar(2);
		
		System.out.println("-- LISTA BORRAR --");
		proDAO.listar();
		System.out.println("-- FIN LISTA --");
		
		p3.setNombre("p33");
		proDAO.actualizar(p3);
		
		System.out.println("-- LISTA ACTUALIZAR --");
		proDAO.listar();
		System.out.println("-- FIN LISTA --");
		
		proDAO.generarFichero("productos.txt");
		
		proDAO.borrarTodos();
		
		System.out.println("-- LISTA BORRADA --");
		proDAO.listar();
		System.out.println("-- FIN LISTA --");
		
		proDAO.recuperarFichero("productos.txt");
		
		System.out.println("-- LISTA RECUPERAR --");
		proDAO.listar();
		System.out.println("-- FIN LISTA --");
	}

}
