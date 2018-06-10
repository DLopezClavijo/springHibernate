package es.altair.excepciones.exception;

public class ExcepcionEstudiante extends RuntimeException {

	private String mensajeEx;

	public ExcepcionEstudiante(String mensajeEx) {
		super();
		this.mensajeEx = mensajeEx;
	}

	public String getMensajeEx() {
		return mensajeEx;
	}

	public void setMensajeEx(String mensajeEx) {
		this.mensajeEx = mensajeEx;
	}

}
