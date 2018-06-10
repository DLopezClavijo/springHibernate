package es.altair.bean;

public class TipoReceta {

	private int idTipoReceta;
	private String tipoReceta;

	public TipoReceta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoReceta(int idTipoReceta, String tipoReceta) {
		super();
		this.idTipoReceta = idTipoReceta;
		this.tipoReceta = tipoReceta;
	}

	public int getIdTipoReceta() {
		return idTipoReceta;
	}

	public void setIdTipoReceta(int idTipoReceta) {
		this.idTipoReceta = idTipoReceta;
	}

	public String getTipoReceta() {
		return tipoReceta;
	}

	public void setTipoReceta(String tipoReceta) {
		this.tipoReceta = tipoReceta;
	}

	@Override
	public String toString() {
		return "TipoReceta [idTipoReceta=" + idTipoReceta + ", tipoReceta=" + tipoReceta + "]";
	}

}
