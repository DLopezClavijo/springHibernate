package dao;

import java.util.HashMap;
import java.util.Set;

import bean.Palabra;

public class DiccionarioImplMap implements DiccionarioDAO {

	private HashMap<String, Palabra> palabras = new HashMap<>();

	@Override
	public void anadir(Palabra p) {
		palabras.put(p.getPalabra(), p);
	}

	@Override
	public Boolean borrar(Palabra p) {
		if (palabras.remove(p.getPalabra())!=null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Boolean buscar(Palabra p) {
		return palabras.containsKey(p.getPalabra());
	}

	@Override
	public String obtenerDefinicion(String texto) {
		return palabras.get(texto).getDefinicion();
	}

	@Override
	public void listar() {
		Set<String> claves = palabras.keySet();
		for (String palabra : claves) {
			Palabra aux = palabras.get(palabra);
			System.out.println(palabra + ": " + aux.getDefinicion());
		}
		
		for (Palabra p : palabras.values()) {
			System.out.println(p.getPalabra() + ": " + p.getDefinicion());
		}
	}

}
