package bean;

public class Palabra {

	private String palabra;
	private String idioma;

	public Palabra() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Palabra(String palabra, String idioma) {
		super();
		this.palabra = palabra;
		this.idioma = idioma;
	}

	public String getPalabra() {
		return palabra;
	}

	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	@Override
	public String toString() {
		return "Palabra [palabra=" + palabra + ", idioma=" + idioma + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idioma == null) ? 0 : idioma.hashCode());
		result = prime * result + ((palabra == null) ? 0 : palabra.hashCode());
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
		Palabra other = (Palabra) obj;
		if (idioma == null) {
			if (other.idioma != null)
				return false;
		} else if (!idioma.equals(other.idioma))
			return false;
		if (palabra == null) {
			if (other.palabra != null)
				return false;
		} else if (!palabra.equals(other.palabra))
			return false;
		return true;
	}

	
}
