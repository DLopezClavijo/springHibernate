package dao;

import java.util.ArrayList;

import bean.Palabra;

public interface PalabraDAO {

	public Boolean incluirPalabra(Palabra p);
	public Boolean incluirFrase(ArrayList<Palabra> palabras);
	
	public void listarPalabrasNuevas();
	public void listarPalabrasRepetidas();
}
