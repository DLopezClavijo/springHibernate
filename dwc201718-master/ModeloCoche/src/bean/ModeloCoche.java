package bean;

public class ModeloCoche {

	private Integer anyo_fab;
	private Integer velocidad;
	private Double precio;
	private String nombre;
	private String marca;

	public ModeloCoche() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ModeloCoche(Integer anyo_fab, Integer velocidad, Double precio, String nombre, String marca) {
		super();
		this.anyo_fab = anyo_fab;
		this.velocidad = velocidad;
		this.precio = precio;
		this.nombre = nombre;
		this.marca = marca;
	}

	public Integer getAnyo_fab() {
		return anyo_fab;
	}

	public void setAnyo_fab(Integer anyo_fab) {
		this.anyo_fab = anyo_fab;
	}

	public Integer getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(Integer velocidad) {
		this.velocidad = velocidad;
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

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public String toString() {
		return "ModeloCoche [anyo_fab=" + anyo_fab + ", velocidad=" + velocidad + ", precio=" + precio + ", nombre="
				+ nombre + ", marca=" + marca + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anyo_fab == null) ? 0 : anyo_fab.hashCode());
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((precio == null) ? 0 : precio.hashCode());
		result = prime * result + ((velocidad == null) ? 0 : velocidad.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModeloCoche other = (ModeloCoche) obj;
		if (anyo_fab == null) {
			if (other.anyo_fab != null)
				return false;
		} else if (!anyo_fab.equals(other.anyo_fab))
			return false;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (precio == null) {
			if (other.precio != null)
				return false;
		} else if (!precio.equals(other.precio))
			return false;
		if (velocidad == null) {
			if (other.velocidad != null)
				return false;
		} else if (!velocidad.equals(other.velocidad))
			return false;
		return true;
	}
	
	
}
