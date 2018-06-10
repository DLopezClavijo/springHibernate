package es.altair.hibernate.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class UsuariosGruposId implements Serializable {

	@ManyToOne(cascade=CascadeType.ALL)
	private Usuario usuario;

	@ManyToOne(cascade=CascadeType.ALL)
	private Grupo grupo;

	public UsuariosGruposId() {
		// TODO Auto-generated constructor stub
	}

	public UsuariosGruposId(Usuario usuario, Grupo grupo) {
		super();
		this.usuario = usuario;
		this.grupo = grupo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

}
