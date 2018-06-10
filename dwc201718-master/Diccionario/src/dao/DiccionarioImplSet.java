package dao;

import java.util.HashSet;
import java.util.Set;

import bean.Palabra;

public class DiccionarioImplSet implements DiccionarioDAO {

	private Set<Palabra> palabras = new HashSet<>();
	
	@Override
	public void anadir(Palabra p) {
		palabras.add(p);
	}

	@Override
	public Boolean borrar(Palabra p) {
		return palabras.remove(p);
	}

	@Override
	public Boolean buscar(Palabra p) {
		return palabras.contains(p);
	}

	@Override
	public String obtenerDefinicion(String pal) {
		for (Palabra palabra : palabras) {
			if (palabra.getPalabra().equalsIgnoreCase(pal)) {
				return palabra.getDefinicion();
			}
		}
		return "";
	}

	@Override
	public void listar() {
		for (Palabra palabra : palabras) {
			System.out.println(palabra.getPalabra() + ": " + palabra.getDefinicion());
		}
	}

}
