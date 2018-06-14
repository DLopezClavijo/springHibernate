package es.altair.bean;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name="componentes") 
public class Componente implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idComponente;
	private String modelo;
	private String marca;
	private byte[] foto;
	private int precio;

	@ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuario usuario;

	public Componente() {
		// TODO Auto-generated constructor stub
	}

	public Componente(String modelo, String marca, byte[] foto, int precio, Usuario usuario) {
		super();
		this.modelo = modelo;
		this.marca = marca;
		this.foto = foto;
		this.precio = precio;
		this.usuario = usuario;
	}

	public int getIdComponente() {
		return idComponente;
	}

	public void setIdComponente(int idComponente) {
		this.idComponente = idComponente;
	}

	public String getTitulo() {
		return modelo;
	}

	public void setTitulo(String modelo) {
		this.modelo = modelo;
	}

	public String getAutor() {
		return marca;
	}

	public void setAutor(String marca) {
		this.marca = marca;
	}

	public byte[] getPortada() {
		return foto;
	}

	public void setPortada(byte[] foto) {
		this.foto = foto;
	}

	public int getUuid() {
		return precio;
	}

	public void setUuid(int precio) {
		this.precio = precio;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Componente [idComponente=" + idComponente + ", modelo=" + modelo + ", marca=" + marca + ", foto="
				+ Arrays.toString(foto) + ", precio=" + precio + ", usuario=" + usuario + "]";
	}

}
