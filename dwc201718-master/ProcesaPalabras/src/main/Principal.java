package main;

import java.util.ArrayList;

import bean.Palabra;
import dao.PalabraDAO;
import dao.PalabraDAOImplSet;

public class Principal {

	public static void main(String[] args) {
		PalabraDAO paDAO = new PalabraDAOImplSet();
		
		Palabra p1 = new Palabra("hola", "español");
		Palabra p2 = new Palabra("adios", "español");
		Palabra p3 = new Palabra("hello", "inglés");
		Palabra p4 = new Palabra("bye", "inglés");
		Palabra p5 = new Palabra("hola", "español");
		
		if (paDAO.incluirPalabra(p1))
			System.out.println(p1.getPalabra() + ": NUEVA");
		else
			System.out.println(p1.getPalabra() + ": REPETIDA");
		if (paDAO.incluirPalabra(p2))
			System.out.println(p2.getPalabra() + ": NUEVA");
		else
			System.out.println(p2.getPalabra() + ": REPETIDA");
		if (paDAO.incluirPalabra(p3))
			System.out.println(p3.getPalabra() + ": NUEVA");
		else
			System.out.println(p3.getPalabra() + ": REPETIDA");
		if (paDAO.incluirPalabra(p4))
			System.out.println(p4.getPalabra() + ": NUEVA");
		else
			System.out.println(p4.getPalabra() + ": REPETIDA");
		if (paDAO.incluirPalabra(p5))
			System.out.println(p5.getPalabra() + ": NUEVA");
		else
			System.out.println(p5.getPalabra() + ": REPETIDA");
		
		ArrayList<Palabra> frase = new ArrayList<>();
		frase.add(new Palabra("hola", "español"));
		frase.add(new Palabra("que", "español"));
		frase.add(new Palabra("tal", "español"));
		
		if (paDAO.incluirFrase(frase))
			System.out.println(frase.toString() + ": NUEVAS");
		else
			System.out.println(frase.toString() + ": ALGUNA REPETIDA");
		
	}

}
