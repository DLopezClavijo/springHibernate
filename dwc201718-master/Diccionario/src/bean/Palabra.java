package bean;

public class Palabra {

	private String palabra;
	private String definicion;

	public Palabra() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Palabra(String palabra, String definicion) {
		super();
		this.palabra = palabra;
		this.definicion = definicion;
	}

	public String getPalabra() {
		return palabra;
	}

	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}

	public String getDefinicion() {
		return definicion;
	}

	public void setDefinicion(String definicion) {
		this.definicion = definicion;
	}

	@Override
	public String toString() {
		return "Diccionario [palabra=" + palabra + ", definicion=" + definicion + "]";
	}

}
