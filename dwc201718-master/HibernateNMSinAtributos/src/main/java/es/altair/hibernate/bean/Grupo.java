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
import javax.persistence.Table;

@Entity
@Table(name="grupos")
public class Grupo implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idGrupo;
	private String nombre;

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
		name="usuariosgrupos", 
		joinColumns = @JoinColumn(name="idGrupo"), 
		inverseJoinColumns = @JoinColumn(name="idUsuario")
	)
	private Set<Usuario> usuarios = new HashSet<Usuario>();

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

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
