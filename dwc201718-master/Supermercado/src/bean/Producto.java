package bean;

public class Producto {

	private Integer codigo;
	private Double precio;
	private String nombre;

	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Producto(Integer codigo, Double precio, String nombre) {
		super();
		this.codigo = codigo;
		this.precio = precio;
		this.nombre = nombre;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", precio=" + precio + ", nombre=" + nombre + "]";
	}

}
