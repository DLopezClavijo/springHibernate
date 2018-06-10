package bean;

public class Alumno {

	private String nombre;
	private String apellidos;
	private Integer edad;
	private Float nota_expediente;

	public Alumno() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Alumno(String nombre, String apellidos, Integer edad, Float nota_expediente) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.nota_expediente = nota_expediente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Float getNota_expediente() {
		return nota_expediente;
	}

	public void setNota_expediente(Float nota_expediente) {
		this.nota_expediente = nota_expediente;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + ", nota_expediente="
				+ nota_expediente + "]";
	}

}
