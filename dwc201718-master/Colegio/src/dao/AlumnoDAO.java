package dao;

import bean.Alumno;

public interface AlumnoDAO {

	public void anadirAlumno(Alumno a);
	
	public Alumno buscaPorNombre(String nombre);
	public Alumno buscaPorApellidos(String apellidos);
	public Alumno buscaPorEdad(Integer edad);
	public Alumno buscaPorNota(Float nota);
	
	public Alumno busca(String patron);
}
