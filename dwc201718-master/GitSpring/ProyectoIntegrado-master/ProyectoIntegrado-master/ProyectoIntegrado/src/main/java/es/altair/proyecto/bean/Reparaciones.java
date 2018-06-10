package es.altair.proyecto.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="reparaciones")
public class Reparaciones implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idReparaciones; 
	private String nombre;
	
	@OneToMany(mappedBy="reparacion")
	private Set<Revisiones> revision = new HashSet<Revisiones>(); 
	
	
	public Reparaciones() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Reparaciones(String nombre) {
		super();
		this.nombre = nombre;
	}


	public int getIdReparacion() {
		return idReparaciones;
	}


	public void setIdReparacion(int idReparaciones) {
		this.idReparaciones = idReparaciones;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	} 
	
	
	

}
