package dao;

import java.util.HashSet;
import java.util.Set;

import bean.Alumno;

public class AlumnoDAOImplConjuntos implements AlumnoDAO {
	
	private Set<Alumno> alumnos = new HashSet<>();

	@Override
	public void anadirAlumno(Alumno a) {
		alumnos.add(a);
	}

	@Override
	public Alumno buscaPorNombre(String nombre) {
		return buscaAlumno(1, nombre);
	}

	@Override
	public Alumno buscaPorApellidos(String apellidos) {
		return buscaAlumno(2, apellidos);
	}

	@Override
	public Alumno buscaPorEdad(Integer edad) {
		return buscaAlumno(3, edad);
	}

	@Override
	public Alumno buscaPorNota(Float nota) {
		return buscaAlumno(4, nota);
	}

	@Override
	public Alumno busca(String patron) {
		return buscaAlumno(0, patron);
	}

	private Alumno buscaAlumno(int i, Object valor) {
		for (Alumno alumno : alumnos) {
			switch (i) {
			case 0: // patron
				if (alumno.toString().toUpperCase().contains(((String)valor).toUpperCase())) {
					return alumno;
				}
				break;
			case 1: // nombre
				if (alumno.getNombre().equalsIgnoreCase((String)valor)) {
					return alumno;
				}
				break;
			case 2: // apellidos
				if (alumno.getApellidos().equalsIgnoreCase((String)valor)) {
					return alumno;
				}
				break;
			case 3: // edad
				if (alumno.getEdad() == ((Integer)valor)) {
					return alumno;
				}
				break;
			case 4: // nota
				if (alumno.getNota_expediente() == ((Float)valor)) {
					return alumno;
				}
				break;

			default:
				break;
			}
		}
		return null;
	}

}
