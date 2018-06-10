package main;

import bean.Palabra;
import dao.DiccionarioDAO;
import dao.DiccionarioImplMap;
import dao.DiccionarioImplSet;

public class Principal {

	public static void main(String[] args) {
		//DiccionarioDAO diccionarioDAO = new DiccionarioImplMap();
		DiccionarioDAO diccionarioDAO = new DiccionarioImplSet();

		Palabra p1 = new Palabra("hola", "saludo formal");
		Palabra p2 = new Palabra("adios", "despedida formal");
		Palabra p3 = new Palabra("mesa", "recipiente para colocar cosas");
		
		diccionarioDAO.anadir(p1);
		diccionarioDAO.anadir(p2);
		diccionarioDAO.anadir(p3);

		diccionarioDAO.listar();

		if (diccionarioDAO.borrar(p3))
			System.out.println("Palabra borrada");
		else
			System.out.println("Palabra no borrada");

		diccionarioDAO.listar();

		if (diccionarioDAO.buscar(p2))
			System.out.println("Palabra encontrada");
		else
			System.out.println("Palabra no encontrada");

		System.out.println("Definición de Hola: " + diccionarioDAO.obtenerDefinicion("hola"));
	}

}
