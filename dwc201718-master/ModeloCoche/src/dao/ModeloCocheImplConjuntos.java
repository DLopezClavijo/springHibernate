package dao;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import bean.ModeloCoche;

public class ModeloCocheImplConjuntos implements ModeloCocheDAO {

	private Set<ModeloCoche> coches = new HashSet<>();
	
	@Override
	public void insertar(ModeloCoche mc) {
		coches.add(mc);
	}

	@Override
	public boolean actualizar(ModeloCoche mcOld, ModeloCoche mcNew) {
		if (coches.remove(mcOld)) {
			coches.add(mcNew);
			return true;
		}		
		return false;
	}

	@Override
	public boolean borrar(ModeloCoche mc) {
		return coches.remove(mc);
	}

	@Override
	public void listar() {
		// -- V1 --
		for (ModeloCoche modeloCoche : coches) {
			System.out.println(modeloCoche);
		}
		System.out.println(coches.size());
		
		// -- V2 --
		Iterator<ModeloCoche> itera = coches.iterator();
		while (itera.hasNext()) {
			ModeloCoche modeloCoche = (ModeloCoche) itera.next();
			System.out.println(modeloCoche);
		}
	}

}
