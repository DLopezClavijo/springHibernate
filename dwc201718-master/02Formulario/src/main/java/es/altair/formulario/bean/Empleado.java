package es.altair.formulario.bean;

public class Empleado {
	private int idEmpleado;
	private String nombre;
	private long salario;
	private int edad;

	public Empleado() {
		// TODO Auto-generated constructor stub
	}

	public Empleado(int idEmpleado, String nombre, long salario, int edad) {
		super();
		this.idEmpleado = idEmpleado;
		this.nombre = nombre;
		this.salario = salario;
		this.edad = edad;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getSalario() {
		return salario;
	}

	public void setSalario(long salario) {
		this.salario = salario;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

}
