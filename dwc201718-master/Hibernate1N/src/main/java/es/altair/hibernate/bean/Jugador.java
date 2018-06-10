package es.altair.hibernate.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="jugador")
public class Jugador implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idJugador;
	private String nombre;
	private String posicion;

	@ManyToOne
	@JoinColumn(name="idEquipo")
	private Equipo equipo;

	public Jugador() {
		// TODO Auto-generated constructor stub
	}

	public Jugador(String nombre, String posicion, Equipo equipo) {
		super();
		this.nombre = nombre;
		this.posicion = posicion;
		this.equipo = equipo;
	}

	public int getIdJugador() {
		return idJugador;
	}

	public void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	@Override
	public String toString() {
		return "Jugador [idJugador=" + idJugador + ", nombre=" + nombre + ", posicion=" + posicion + ", equipo="
				+ equipo + "]";
	}

}
