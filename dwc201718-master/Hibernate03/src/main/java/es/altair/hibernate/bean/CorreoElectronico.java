package es.altair.hibernate.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="correoelectronico")
public class CorreoElectronico implements Serializable {

	@Id
	private int IdCorreo;
	private String DireccionCorreo;

	@ManyToOne
	@JoinColumn(name="idProfesor")
	private Profesor profesor;

	public CorreoElectronico() {
		// TODO Auto-generated constructor stub
	}

	public CorreoElectronico(int idCorreo, String direccionCorreo, Profesor profesor) {
		super();
		IdCorreo = idCorreo;
		DireccionCorreo = direccionCorreo;
		this.profesor = profesor;
	}

	public int getIdCorreo() {
		return IdCorreo;
	}

	public void setIdCorreo(int idCorreo) {
		IdCorreo = idCorreo;
	}

	public String getDireccionCorreo() {
		return DireccionCorreo;
	}

	public void setDireccionCorreo(String direccionCorreo) {
		DireccionCorreo = direccionCorreo;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

}
