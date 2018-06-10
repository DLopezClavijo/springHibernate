package main;

import java.util.Scanner;

import bean.Alumno;
import dao.AlumnoDAO;
import dao.AlumnoDAOImplConjuntos;
import dao.AlumnoDAOImplListas;

public class Principal {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		//AlumnoDAO alumDAO = new AlumnoDAOImplListas();
		
		AlumnoDAO alumDAO = new AlumnoDAOImplConjuntos();

		Alumno a1 = new Alumno("n1", "ap1", 22, 3.4F);
		Alumno a2 = new Alumno("n2", "ap2", 23, 4.4F);
		Alumno a3 = new Alumno("n3", "ap3", 24, 5.4F);

		alumDAO.anadirAlumno(a1);
		alumDAO.anadirAlumno(a2);
		alumDAO.anadirAlumno(a3);

		System.out.println("Nombre:");
		String nombre = sc.next();
		System.out.println("El alumno con nombre igual a " + nombre + 
				" es " + alumDAO.buscaPorNombre(nombre));
		
		System.out.println("Edad:");
		Integer edad = sc.nextInt();
		System.out.println("El alumno con edad igual a " + edad + 
				" es " + alumDAO.buscaPorEdad(edad));
		
		System.out.println("Patrón:");
		String patron = sc.next();
		System.out.println("El alumno con algo igual a " + patron + 
				" es " + alumDAO.busca(patron));

		sc.close();
	}

}
