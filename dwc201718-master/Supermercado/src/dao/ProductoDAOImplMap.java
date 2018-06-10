package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import bean.Producto;

public class ProductoDAOImplMap implements ProductoDAO {
	
	private Map<Integer, Producto> productos = new HashMap<>();

	@Override
	public void anadir(Producto p) {
		productos.put(p.getCodigo(), p);
	}

	@Override
	public Boolean borrar(Integer codigo) {
		if (productos.containsKey(codigo)) {
			productos.remove(codigo);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Boolean actualizar(Producto p) {
		if (productos.containsKey(p.getCodigo())) {
			Producto aux = productos.replace(p.getCodigo(), p);
			if (aux != null)
				return true;
			else
				return false;
		} else {
			return false;
		}
	}

	@Override
	public void listar() {
		// 1ª Forma
		for (Producto p : productos.values()) {
			System.out.println(p);
		}
		
		// 2ª Forma
//		Set<Integer> claves = productos.keySet();
//		Iterator<Integer> iterador = claves.iterator();
//		while (iterador.hasNext()) {
//			Integer cla = (Integer) iterador.next();
//			System.out.println(productos.get(cla));
//			
//		}
	}

	@Override
	public void borrarTodos() {
		productos.clear();
	}

	@Override
	public void generarFichero(String nombreFichero) {
		File fichero = new File(nombreFichero);
		if (!fichero.exists()) {
			try {
				fichero.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			fw = new FileWriter(fichero);
			bw = new BufferedWriter(fw);
			
			for (Producto p : productos.values()) {
				bw.write(p.getCodigo() + ";" + p.getNombre() + ";" + p.getPrecio());
				bw.newLine();
				bw.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bw.close();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void recuperarFichero(String nombreFichero) {
		File fichero = new File(nombreFichero);
		if (fichero.exists()) {
			FileReader fr = null;
			BufferedReader br = null;
			
			try {
				fr = new FileReader(fichero);
				br = new BufferedReader(fr);
				
				String linea;
				while ((linea=br.readLine())!=null) {
					String [] partes = linea.split(";");
					Producto p = new Producto(Integer.parseInt(partes[0]), 
							Double.parseDouble(partes[2]), partes[1]);
					anadir(p);					
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					br.close();
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {
			System.out.println("Error en el fichero");
		}
	}

}
