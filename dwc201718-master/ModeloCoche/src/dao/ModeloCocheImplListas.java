package dao;

import java.util.ArrayList;
import java.util.List;

import bean.ModeloCoche;

public class ModeloCocheImplListas implements ModeloCocheDAO {

	private List<ModeloCoche> coches = new ArrayList<>();
	
	@Override
	public void insertar(ModeloCoche mc) {
		coches.add(mc);
	}

	@Override
	public boolean actualizar(ModeloCoche mcOld, ModeloCoche mcNew) {
		if (coches.contains(mcOld)) {
			coches.set(coches.indexOf(mcOld), mcNew);
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
		for (ModeloCoche modeloCoche : coches) {
			System.out.println(modeloCoche);
		}
//		for (int i = 0; i < coches.size(); i++) {
//			System.out.println(coches.get(i));
//		}
		
		System.out.println(coches.size());
	}

}
