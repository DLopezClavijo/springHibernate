package bean;

import java.util.ArrayList;

public class Medicion {

	private String identificador;
	private ArrayList<Integer> temperaturas = new ArrayList<>();

	public Medicion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Medicion(String identificador, ArrayList<Integer> temperaturas) {
		super();
		this.identificador = identificador;
		this.temperaturas = temperaturas;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public ArrayList<Integer> getTemperaturas() {
		return temperaturas;
	}

	public void setTemperaturas(ArrayList<Integer> temperaturas) {
		this.temperaturas = temperaturas;
	}

	@Override
	public String toString() {
		return "Medicion [identificador=" + identificador + ", temperaturas=" + temperaturas + "]";
	}

}
