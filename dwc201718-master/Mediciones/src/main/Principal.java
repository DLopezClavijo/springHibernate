package main;

import dao.MedicionDAO;
import dao.MedicionDAOImplMap;

public class Principal {

	public static void main(String[] args) {
		MedicionDAO meDAO = new MedicionDAOImplMap();
		
		meDAO.leerYGuardarMenor("mediciones.txt", "medicionesMin.txt");
	}

}
