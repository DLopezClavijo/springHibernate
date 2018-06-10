package es.altair.hibernate.bean;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.ScriptAssert;

@Entity
@Table(name = "equipo")
@ScriptAssert.List({
		@ScriptAssert(lang="javascript", script="(_this.numSocios>200000)? true : false", message="Número Socios debería ser mayor que 200000")
})
public class Equipo implements Serializable {
	
//	@Email
//	@Past
//	@Future
//	@Digits
//	@Max

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEquipo;

	@Size(min=5, max=10)
	private String nombre;

	@NotNull
	@NotBlank
	private String ciudad;

	@Min(value=50000)
	private int numSocios;

	@OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL)
	private Set<Jugador> jugadores;

	public Equipo() {
		// TODO Auto-generated constructor stub
	}

	public Equipo(String nombre, String ciudad, int numSocios) {
		super();
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.numSocios = numSocios;
	}

	public Equipo(String nombre, int numSocios) {
		super();
		this.nombre = nombre;
		this.numSocios = numSocios;
	}

	public int getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public int getNumSocios() {
		return numSocios;
	}

	public void setNumSocios(int numSocios) {
		this.numSocios = numSocios;
	}

	public Set<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(Set<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	@Override
	public String toString() {
		return "Equipo [idEquipo=" + idEquipo + ", nombre=" + nombre + ", ciudad=" + ciudad + ", numSocios=" + numSocios
				+ "]";
	}

	@AssertTrue(message="NO ES DE SEVILLA")
	private boolean isCiudad() {
		return ciudad.equalsIgnoreCase("Sevilla");
	}
}
