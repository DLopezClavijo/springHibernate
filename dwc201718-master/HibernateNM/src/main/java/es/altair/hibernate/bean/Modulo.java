package es.altair.hibernate.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="modulo")
public class Modulo implements Serializable {

	@Id
	private int idModulo;
	private String nombre;
	
	@ManyToMany(cascade=CascadeType.ALL, mappedBy="modulos")
	private Set<Profesor> profesores = new HashSet<Profesor>();

	public Modulo() {
		// TODO Auto-generated constructor stub
	}

	public Modulo(int idModulo, String nombre) {
		super();
		this.idModulo = idModulo;
		this.nombre = nombre;
	}

	public int getIdModulo() {
		return idModulo;
	}

	public void setIdModulo(int idModulo) {
		this.idModulo = idModulo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Set<Profesor> getProfesores() {
		return profesores;
	}
	
	public void setProfesores(Set<Profesor> profesores) {
		this.profesores = profesores;
	}

}
