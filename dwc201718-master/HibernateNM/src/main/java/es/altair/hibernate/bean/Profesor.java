package es.altair.hibernate.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="profesor")
public class Profesor implements Serializable {

	@Id
	private int id;
	private String nombre;
	private String ape1;
	private String ape2;

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="profesormodulo", 
			joinColumns = { @JoinColumn(name="idProfesor") }, 
			inverseJoinColumns = { @JoinColumn(name="idModulo") })
	private Set<Modulo> modulos = new HashSet<Modulo>();

	public Profesor() {
		// TODO Auto-generated constructor stub
	}

	public Profesor(int id, String nombre, String ape1, String ape2) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ape1 = ape1;
		this.ape2 = ape2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApe1() {
		return ape1;
	}

	public void setApe1(String ape1) {
		this.ape1 = ape1;
	}

	public String getApe2() {
		return ape2;
	}

	public void setApe2(String ape2) {
		this.ape2 = ape2;
	}

	public Set<Modulo> getModulos() {
		return modulos;
	}

	public void setModulos(Set<Modulo> modulos) {
		this.modulos = modulos;
	}

}
