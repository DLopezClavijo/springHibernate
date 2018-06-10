package es.altair.hibernate.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="usuariosgrupos")
public class UsuarioGrupo implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUsuarioGrupo;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idUsuario")
	private Usuario usuario;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idGrupo")
	private Grupo grupo;

	private boolean activado;

	@Temporal(TemporalType.DATE)
	private Date fecha_registro;

	public UsuarioGrupo() {
		// TODO Auto-generated constructor stub
	}

	public UsuarioGrupo(Usuario usuario, Grupo grupo, boolean activado, Date fecha_registro) {
		super();
		this.usuario = usuario;
		this.grupo = grupo;
		this.activado = activado;
		this.fecha_registro = fecha_registro;
	}

	public int getIdUsuarioGrupo() {
		return idUsuarioGrupo;
	}

	public void setIdUsuarioGrupo(int idUsuarioGrupo) {
		this.idUsuarioGrupo = idUsuarioGrupo;
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

	public boolean isActivado() {
		return activado;
	}

	public void setActivado(boolean activado) {
		this.activado = activado;
	}

	public Date getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

}
