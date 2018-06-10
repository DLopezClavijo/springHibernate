package dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import bean.Palabra;

public class PalabraDAOImplSet implements PalabraDAO {
	
	private Set<Palabra> palabrasNuevas = new HashSet<>();
	private Set<Palabra> palabrasRepetidas = new HashSet<>();

	@Override
	public Boolean incluirPalabra(Palabra p) {
		if (palabrasNuevas.add(p)) {
			return true;
		} else {
			palabrasRepetidas.add(p);
			return false;
		}
	}

	@Override
	public Boolean incluirFrase(ArrayList<Palabra> palabras) {
		Boolean todasNuevas = true;
		
		for (Palabra palabra : palabras) {
			if (!incluirPalabra(palabra))
				todasNuevas = false;
		}
		return todasNuevas;
	}

	@Override
	public void listarPalabrasNuevas() {
		for (Palabra palabra : palabrasNuevas) {
			System.out.println(palabra);
		}
	}

	@Override
	public void listarPalabrasRepetidas() {
		for (Palabra palabra : palabrasRepetidas) {
			System.out.println(palabra);
		}
	}

}
