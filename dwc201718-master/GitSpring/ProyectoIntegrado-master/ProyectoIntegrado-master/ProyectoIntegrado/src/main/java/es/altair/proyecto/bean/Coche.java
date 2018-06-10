package es.altair.proyecto.bean;

import java.io.Serializable;
import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="coches")
public class Coche implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCoche;
	private String matricula; 
	private String marca; 
	private String modelo; 
	private String anyo; 
	private String motor; 
	private String potencia; 
	
	

	public Set<Revisiones> getRevision() {
		return revision;
	}

	public void setRevision(Set<Revisiones> revision) {
		this.revision = revision;
	}

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="usuarioId")
	private Usuario usuario;
	
	@OneToMany(mappedBy="coche")
	private Set<Revisiones> revision = new HashSet<Revisiones>(); 
	
	public Coche() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Coche(int idCoche, String matricula, String marca, String modelo, Usuario usuario,String anyo, String motor, String potencia) {
		super();
		this.idCoche = idCoche;
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.usuario = usuario;
		this.anyo = anyo; 
		this.motor = motor; 
		this.potencia = potencia; 
	}
	public Coche(int idCoche, String matricula, String marca, String modelo,String anyo, String motor, String potencia) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.anyo = anyo; 
		this.motor = motor; 
		this.potencia = potencia; 
	}

	

	public int getIdCoche() {
		return idCoche;
	}

	public void setIdCoche(int idCoche) {
		this.idCoche = idCoche;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getAnyo() {
		return anyo;
	}

	public void setAnyo(String anyo) {
		this.anyo = anyo;
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public String getPotencia() {
		return potencia;
	}

	public void setPotencia(String potencia) {
		this.potencia = potencia;
	}

	
}
