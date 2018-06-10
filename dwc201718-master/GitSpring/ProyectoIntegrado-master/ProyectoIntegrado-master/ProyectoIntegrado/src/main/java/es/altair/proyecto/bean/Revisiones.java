package es.altair.proyecto.bean;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="revisiones")
public class Revisiones {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRevision; 
	private Date fecha; 
	private String kilometros; 
	private String observaciones; 
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idCoche")
	private Coche coche; 
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idReparacion")
	private Reparaciones reparacion; 
	
	private float precio;

	public Revisiones() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Revisiones(int idRevision, Date fecha, String kilometros, String observaciones, Coche coche,
			Reparaciones reparacion, float precio) {
		super();
		this.idRevision = idRevision;
		this.fecha = fecha;
		this.kilometros = kilometros;
		this.observaciones = observaciones;
		this.coche = coche;
		this.reparacion = reparacion;
		this.precio = precio;
	}

	public Revisiones(Date fecha, String kilometros, Coche coche, Reparaciones reparacion,
			float precio) {
		super();
		this.fecha = fecha;
		this.kilometros = kilometros;
		this.coche = coche;
		this.reparacion = reparacion;
		this.precio = precio;
	}
	public Revisiones(Date fecha, String kilometros, Coche coche,
			float precio) {
		super();
		this.fecha = fecha;
		this.kilometros = kilometros;
		this.coche = coche;
		this.precio = precio;
	}

	public int getIdRevision() {
		return idRevision;
	}

	public void setIdRevision(int idRevision) {
		this.idRevision = idRevision;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getKilometros() {
		return kilometros;
	}

	public void setKilometros(String kilometros) {
		this.kilometros = kilometros;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Coche getCoche() {
		return coche;
	}

	public void setCoche(Coche coche) {
		this.coche = coche;
	}

	public Reparaciones getReparacion() {
		return reparacion;
	}

	public void setReparacion(Reparaciones reparacion) {
		this.reparacion = reparacion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}  
	
	
	
	
	

}
