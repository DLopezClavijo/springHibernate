package es.altair.hibernate.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "grupos")
public class Grupo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idGrupo;
	private String nombre;

	// asociación 1:N desde la tabla grupos a la tabla usuariosgrupos
	@OneToMany(mappedBy = "grupo")
	private Set<UsuarioGrupo> usuariosgrupos = new HashSet<UsuarioGrupo>();

	public Grupo() {
		// TODO Auto-generated constructor stub
	}

	public Grupo(String nombre) {
		super();
		this.nombre = nombre;
	}

	public int getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(int idGrupo) {
		this.idGrupo = idGrupo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<UsuarioGrupo> getUsuariosgrupos() {
		return usuariosgrupos;
	}

	public void setUsuariosgrupos(Set<UsuarioGrupo> usuariosgrupos) {
		this.usuariosgrupos = usuariosgrupos;
	}

}
